package ua.examples.practice.leetCodeTasks.easy;

import ua.examples.practice.leetCodeTasks.BaseLogger;

import java.util.Arrays;

/**
 * Task: Given an array of integers, return indices of the two numbers such
 * that they add up to a specific target.
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @author Ihor Savchenko
 * @version 1.0
 */
public class TwoSum extends BaseLogger {

    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length-1; i++){
            for(int j = 1+i; j < nums.length; j++){
                if((nums[i] + nums[j]) == target){
                    return new int[] {i, j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {

        int[] result = new TwoSum().twoSum(new int[]{5, -7, 10, 12, 24}, 22);
        logger.info("Result is: " + Arrays.toString(result));
    }
}
