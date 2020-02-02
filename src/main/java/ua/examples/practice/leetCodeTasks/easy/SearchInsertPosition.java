package ua.examples.practice.leetCodeTasks.easy;

import ua.examples.practice.leetCodeTasks.BaseLogger;

/**
 * Task: Given a sorted array and a target value, return the index
 * if the target is found. If not, return the index where it would be
 * if it were inserted in order.
 * You may assume no duplicates in the array.
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * Input: [1,3,5,6], 2
 * Output: 1
 * Input: [1,3,5,6], 7
 * Output: 4
 * Input: [1,3,5,6], 0
 * Output: 0
 *
 * @author Ihor Savchenko
 * @version 1.0
 */
public class SearchInsertPosition extends BaseLogger {

    public int searchInsert(int[] nums, int target) {

        if(nums == null || nums.length == 0) return 0;
        if(target < nums[0]) return 0;
        if(target > nums[nums.length-1]) return nums.length;

        int index = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == target){
                index = i;
                break;
            }
            if(target > nums[i-1] && target < nums[i]){
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {

        int result = new SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 7);
        logger.info("Number of position: " + String.valueOf(result));
    }
}
