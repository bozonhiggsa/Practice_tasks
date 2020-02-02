package ua.examples.practice.leetCodeTasks.easy;

import ua.examples.practice.leetCodeTasks.BaseLogger;

import java.util.Arrays;

/**
 * Task: Given a sorted array, remove the duplicates in-place such that each
 * element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 *
 * Given nums = [1,1,2],
 * Function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 *
 * @author Ihor Savchenko
 * @version 1.0
 */
public class RemoveDuplicatesFromSortedArray extends BaseLogger {

    static int[] numbers = {0,0,0,0,1,1,1,2,2,3,3,3,3,4,4,4};

    public int removeDuplicates(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }
        int length = nums.length;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                length--;
            }
        }
        int index = 1;
        for(int i = 0; i < length; i++){
            for(int k = index; k < nums.length; k++){
                if(nums[i] != nums[k]){
                    nums[i+1] = nums[k];
                    index = k + 1;
                    break;
                }
            }
        }
        for(int i = length; i < nums.length; i++){
            nums[i] = 0;
        }
        return length;
    }

    public static void main(String[] args) {

        logger.info("The source sorted array: " + Arrays.toString(numbers));
        int result = new RemoveDuplicatesFromSortedArray().removeDuplicates(numbers);
        logger.info("Now the array's length for unique numbers: " + String.valueOf(result));
        logger.info("The array after of handling: " + Arrays.toString(numbers));
    }
}
