package ua.examples.practice.leetCodeTasks.easy;

import ua.examples.practice.leetCodeTasks.BaseLogger;

/**
 * Task: Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example:
 * Input: 123
 * Output:  321
 *
 * Input: -123
 * Output: -321
 *
 * Input: 120
 * Output: 21
 *
 * Assume we are dealing with an environment which could only hold integers
 * within the 32-bit signed integer range. For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 *
 * @author Ihor Savchenko
 * @version 1.0
 */
public class ReverseInteger2 extends BaseLogger {

    public int reverse(int x) {

        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }

    public static void main(String[] args) {

        int result = new ReverseInteger().reverse(-206446479);
        logger.info("Result is: " + result);
    }
}
