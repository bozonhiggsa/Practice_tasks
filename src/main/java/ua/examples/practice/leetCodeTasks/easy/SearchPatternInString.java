package ua.examples.practice.leetCodeTasks.easy;

import ua.examples.practice.leetCodeTasks.BaseLogger;

/**
 * Task: Return the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * @author Ihor Savchenko
 * @version 1.0
 */
public class SearchPatternInString extends BaseLogger {

    public int strStr(String haystack, String needle) {

        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {

        String haystack = "aaaaa";
        String needle = "bba";
        logger.info("haystack: " + haystack);
        logger.info("needle: " + needle);
        int result = new SearchPatternInString().strStr(haystack, needle);
        logger.info("Result: " + String.valueOf(result));
    }
}
