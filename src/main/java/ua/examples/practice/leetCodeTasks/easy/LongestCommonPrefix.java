package ua.examples.practice.leetCodeTasks.easy;

import ua.examples.practice.leetCodeTasks.BaseLogger;

/**
 * Write a function to find the longest common prefix string
 * amongst an array of strings.
 *
 * @author Ihor Savchenko
 * @version 1.0
 */
public class LongestCommonPrefix extends BaseLogger {

    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0) return "";
        int lengthStringMin = strs[0].length();
        for(int i = 1; i < strs.length; i++){
            if(strs[i].length() < lengthStringMin){
                lengthStringMin = strs[i].length();
            }
        }
        String result = "";

        for(int i = 0; i < lengthStringMin; i++){
            char ch = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != ch) return result;
            }
            result = result + ch;
        }
        return result;
    }

    public static void main(String[] args) {

        String result = new LongestCommonPrefix().longestCommonPrefix(new String[]{"ergeg", "erguilul", "ersdf"});
        logger.info("That prefix is longest for these strings: " + result);
    }
}
