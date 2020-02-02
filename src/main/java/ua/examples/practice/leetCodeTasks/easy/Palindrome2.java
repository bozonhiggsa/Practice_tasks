package ua.examples.practice.leetCodeTasks.easy;

import ua.examples.practice.leetCodeTasks.BaseLogger;

/**
 * Task: Determine whether an integer is a palindrome. Do this without extra space.
 *
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * If you are thinking of converting the integer to string, note the restriction
 * of using extra space.
 * You could also try reversing an integer. However, if you have solved the problem
 * "Reverse Integer", you know that the reversed integer might overflow.
 * How would you handle such case?
 * There is a more generic way of solving this problem.
 *
 * @author Ihor Savchenko
 * @version 1.0
 */
public class Palindrome2 extends BaseLogger {

    public boolean isPalindrome(int x) {

        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x > rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }

    public static void main(String[] args) {

        boolean result = new Palindrome2().isPalindrome(10901);
        logger.info("This integer is a palindrome: " + result);
    }
}
