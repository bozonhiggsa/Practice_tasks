package ua.examples.practice.practice7;

import ua.examples.practice.practice7.db.DBException;
import ua.examples.practice.practice7.db.DBManager;
import ua.examples.practice.practice7.db.entity.Group;
import ua.examples.practice.practice7.db.entity.User;

import java.sql.SQLException;
import java.util.List;

public class Demo {

    private static final String URL =
            "jdbc:derby:C:/Apache/db-derby-10.14.2.0-bin/db/practiceDB";

    // QUERIES
    /////////////////////////////////////////
    private static final String SQL_SELECT_ALL_USERS =
            "select * from practiceDB.users";


    private static <T> void printList(List<T> list) {

        for (T element : list) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) throws SQLException, DBException {

        // users  ==> [ivanov]
        // groups ==> [teamA]

        DBManager dbManager = DBManager.getInstance();

        // Part 1
        dbManager.insertUser(User.createUser("petrov"));
        dbManager.insertUser(User.createUser("obama"));
        printList(dbManager.findAllUsers());
        // users  ==> [ivanov, petrov, obama]

        System.out.println("===========================");

        // Part 2
        dbManager.insertGroup(Group.createGroup("teamB"));
        dbManager.insertGroup(Group.createGroup("teamC"));
        printList(dbManager.findAllGroups());
        // groups ==> [teamA, teamB, teamC]

        System.out.println("===========================");

        // Part 3
        User userPetrov = dbManager.getUser("petrov");
        User userIvanov = dbManager.getUser("ivanov");
        User userObama = dbManager.getUser("obama");

        Group teamA = dbManager.getGroup("teamA");
        Group teamB = dbManager.getGroup("teamB");
        Group teamC = dbManager.getGroup("teamC");

        // method setGroupsForUser must implement transaction!
        dbManager.setGroupsForUser(userIvanov, teamA);
        dbManager.setGroupsForUser(userPetrov, teamA, teamB);
        dbManager.setGroupsForUser(userObama, teamA, teamB, teamC);

        for (User user : dbManager.findAllUsers()) {
            printList(dbManager.getUserGroups(user));
            System.out.println("~~~~~");
        }
        // teamA
        // teamA teamB
        // teamA teamB teamC

        System.out.println("===========================");
        // Part 4
        dbManager.deleteGroup(teamA);
        // Part 5
        teamC.setName("teamX");
        dbManager.updateGroup(teamC);
        // Part 6
        printList(dbManager.findAllGroups());
        // groups ==> [teamB, teamX]
    }
}