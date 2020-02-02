package ua.examples.practice.practice7.db.entity;

public class User {

    public User() {
    }

    public static User createUser(String login) {

        User user = new User();
        user.setLogin(login);
        return user;
    }

    private int id;
    private String login;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return login;
    }
}
