package ua.examples.practice.leetCodeTasks.easy;

import ua.examples.practice.leetCodeTasks.BaseLogger;

import java.util.Stack;

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
public class ReverseInteger extends BaseLogger {

    public int reverse(int x) {

        char[] chars = Integer.toString(x).toCharArray();
        char[] charsOut = new char[chars.length];
        int k = 0;

        Stack<Character> characters = new Stack<>();
        if(Integer.signum(x) < 0){
            k = 1;
            charsOut[0] = '-';
        }

        for (int i = k; i < chars.length; i++){
            characters.add(chars[i]);
        }
        for (int i = k; i < chars.length; i++){
            charsOut[i] = characters.pop();
        }

        try{
            x = Integer.parseInt(new String(charsOut));
        }
        catch (NumberFormatException e){
            return 0;
        }

        return x;
    }

    public static void main(String[] args) {

        int result = new ReverseInteger().reverse(-206446479);
        logger.info("Result is: " + result);
    }
}
