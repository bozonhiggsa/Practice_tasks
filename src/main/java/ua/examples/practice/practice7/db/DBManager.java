package ua.examples.practice.practice7.db;

import ua.examples.practice.practice7.db.entity.Group;
import ua.examples.practice.practice7.db.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private static final String URL =
            "jdbc:derby:C:/Apache/db-derby-10.14.2.0-bin/db/practiceDB;create=true";

    // QUERIES
    private static final String SQL_FIND_ALL_USERS = "select * from practiceDB.users";
    private static final String SQL_FIND_ALL_GROUPS = "select * from practiceDB.groups";
    private static final String SQL_FIND_USER_GROUPS = "select * from practiceDB.groups AS G where G.id IN (SELECT id_group from practiceDB.users_groups AS UG where UG.id_user=?)";


    private static final String SQL_FIND_USER = "select * from practiceDB.users where login=?";
    private static final String SQL_FIND_GROUP = "select * from practiceDB.groups where name=?";


    private static final String SQL_CREATE_USER =
            "insert into practiceDB.users(id, login) values (default, ?)";

    private static final String SQL_CREATE_GROUP =
            "insert into practiceDB.groups(id, name) values (default, ?)";

    private static final String SQL_DELETE_GROUP =
            "delete from practiceDB.groups where name = ?";

    private static final String SQL_UPDATE_GROUP =
            "update practiceDB.groups SET name = ? where id = ?";

    public static final String ADD_GROUP_FOR_USER = "INSERT INTO practiceDB.users_groups(id_user, id_group) VALUES(?, ?)";

    // SINGLETON
    private static DBManager instance;

    public static synchronized DBManager getInstance() {

        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    // JDBC methods

    public List<User> findAllUsers() throws SQLException {

        List<User> users = new ArrayList<>();
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL_FIND_ALL_USERS);
        while (rs.next()) {
            users.add(extract(rs));
        }
        con.close();
        return users;
    }

    public List<Group> findAllGroups() throws SQLException {

        List<Group> groups = new ArrayList<>();
        Connection con = getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(SQL_FIND_ALL_GROUPS);
        while (rs.next()) {
            groups.add(extractGroup(rs));
        }
        con.close();
        return groups;
    }

    public User getUser(String login) throws SQLException {

        User user = null;
        Connection con = getConnection();

        PreparedStatement pstmt = con.prepareStatement(SQL_FIND_USER);
        pstmt.setString(1, login);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            user = extract(rs);
        }
        con.close();
        return user;
    }

    public Group getGroup(String name) throws SQLException {

        Group group = null;
        Connection con = getConnection();

        PreparedStatement pstmt = con.prepareStatement(SQL_FIND_GROUP);
        pstmt.setString(1, name);

        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            group = extractGroup(rs);
        }
        con.close();
        return group;
    }

    public List<Group> getUserGroups(User user) throws SQLException {

        List<Group> groups = new ArrayList<>();
        Connection con = getConnection();

        PreparedStatement pstmt = con.prepareStatement(SQL_FIND_USER_GROUPS);
        pstmt.setInt(1, user.getId());

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            groups.add(extractGroup(rs));
        }
        con.close();
        return groups;
    }

    public boolean insertUser(User user) throws SQLException {

        boolean res = false;
        Connection con = getConnection();

        PreparedStatement pstmt = con.prepareStatement(SQL_CREATE_USER, Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, user.getLogin());

        if (pstmt.executeUpdate() > 0) {
            res = true;
            ResultSet rs = pstmt.getGeneratedKeys(); // 1
            if (rs.next()) {
                user.setId(rs.getInt(1));
            }
        }
        return res;
    }

    public boolean insertGroup(Group group) throws SQLException {

        boolean res = false;
        Connection con = getConnection();

        PreparedStatement pstmt = con.prepareStatement(SQL_CREATE_GROUP, Statement.RETURN_GENERATED_KEYS);

        pstmt.setString(1, group.getName());

        if (pstmt.executeUpdate() > 0) {
            res = true;
            ResultSet rs = pstmt.getGeneratedKeys(); // 1
            if (rs.next()) {
                group.setId(rs.getInt(1));
            }
        }
        return res;
    }

    public void setGroupsForUser(User user, Group... groups) throws DBException {

        int numberGroups = groups.length;

        Connection con = null;
        PreparedStatement preparedStatement = null;
        try{
            con = getConnection();
            con.setAutoCommit(false);
            con.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            preparedStatement = con.prepareStatement(ADD_GROUP_FOR_USER);
            for(int j = 0; j < numberGroups; j++){
                int k = 1;
                preparedStatement.setInt(k++, user.getId());
                preparedStatement.setInt(k++, groups[j].getId());
                preparedStatement.executeUpdate();
            }
            con.commit();
        }
        catch(SQLException e){
            JdbcUtils.rollbackQuietly(con);
            throw new DBException("Can't execute SQL = '" + ADD_GROUP_FOR_USER, e);
        }
        finally{
            JdbcUtils.closeQuietly(preparedStatement);
            JdbcUtils.closeQuietly(con);
        }
    }

    public boolean deleteGroup(Group group) throws SQLException {

        boolean res = false;
        Connection con = getConnection();

        PreparedStatement pstmt = con.prepareStatement(SQL_DELETE_GROUP);

        pstmt.setString(1, group.getName());

        if (pstmt.executeUpdate() > 0) {
            res = true;
        }
        return res;
    }

    public boolean updateGroup(Group group) throws SQLException {

        boolean res = false;
        Connection con = getConnection();

        PreparedStatement pstmt = con.prepareStatement(SQL_UPDATE_GROUP);

        int k = 1;
        pstmt.setString(k++, group.getName());
        pstmt.setInt(k++, group.getId());

        if (pstmt.executeUpdate() > 0) {
            res = true;
        }
        return res;
    }

    // UTIL METHODS

    private Connection getConnection() throws SQLException {

        Connection con = DriverManager.getConnection(URL);
        // adjust a connection
        return con;
    }

    private User extract(ResultSet rs) throws SQLException {

        User user = new User();
        user.setId(rs.getInt("id"));
        user.setLogin(rs.getString("login"));
        return user;
    }

    private Group extractGroup(ResultSet rs) throws SQLException {

        Group group = new Group();
        group.setId(rs.getInt("id"));
        group.setName(rs.getString("name"));
        return group;
    }
}

