package ua.examples.practice.leetCodeTasks.easy;

import ua.examples.practice.leetCodeTasks.BaseLogger;

/**
 * Task: Determine whether an integer is a palindrome.
 *
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * There is a more generic way of solving this problem.
 *
 * @author Ihor Savchenko
 * @version 1.0
 */
public class Palindrome extends BaseLogger {

    public boolean isPalindrome(int x) {

        if(Integer.signum(x) < 0) return false;
        if(Integer.signum(x) == 0) return true;
        char[] digits = Integer.toString(x).toCharArray();
        for(int i = 0; i < (digits.length/2); i++){
            if(digits[i] != digits[digits.length - 1 - i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        boolean result = new Palindrome().isPalindrome(90509);
        logger.info("This integer is a palindrome: " + result);
    }
}
