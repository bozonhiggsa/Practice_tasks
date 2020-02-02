package ua.examples.practice.leetCodeTasks.easy;

import ua.examples.practice.leetCodeTasks.BaseLogger;

import java.util.Arrays;

/**
 * Task: Given an array and a value, remove all instances of that
 * value in-place and return the new length.
 * Do not allocate extra space for another array,
 * you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Given nums = [3,2,2,3], val = 3,
 * Your function should return length = 2,
 * with the first two elements of nums being 2.
 *
 * @author Ihor Savchenko
 * @version 1.0
 */
public class RemoveElement extends BaseLogger {

    static int[] numbers = {2,2,3,3,1,0,3,1,1,5,7,2};

    public int removeElement(int[] nums, int val) {

        if(nums == null || nums.length == 0) return 0;

        int length = nums.length;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val){
                length--;
            }
        }

        int index = 0;
        for(int i = 0; i < length; i++){
            for(int k = index; k < nums.length; k++){
                if(nums[k] != val){
                    nums[i] = nums[k];
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

        logger.info("The source array: " + Arrays.toString(numbers));
        int result = new RemoveElement().removeElement(numbers, 3);
        logger.info("Now the array's length for remain numbers: " + String.valueOf(result));
        logger.info("The array after of handling: " + Arrays.toString(numbers));
    }
}
