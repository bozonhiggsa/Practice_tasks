package ua.examples.practice.leetCodeTasks.easy;

import ua.examples.practice.leetCodeTasks.BaseLogger;

/**
 * Write a function to find the longest common prefix string
 * amongst an array of strings.
 *
 * @author Ihor Savchenko
 * @version 1.0
 */
public class LongestCommonPrefix2 extends BaseLogger {

    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
            i++;
        }
        return pre;
    }

    public static void main(String[] args) {

        String result = new LongestCommonPrefix().longestCommonPrefix(new String[]{"ergeg", "ergerguilul", "ergfbdbsdf"});
        logger.info("That prefix is longest for these strings: " + result);
    }
}
