package ua.examples.practice.practice7.db;

/**
 * Own Exception superclass for intercept exceptional situations while interacting with database.
 * @author Ihor Savchenko
 */

public class DBException extends Exception {

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }
}
