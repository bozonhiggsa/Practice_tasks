package ua.examples.practice.leetCodeTasks.middle;

import ua.examples.practice.leetCodeTasks.BaseLogger;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Search the least number of a taxi for transferring all groups of people,
 * without their partitioning.
 * The taxi can transfer less than or equal to 4 person at one time.
 * @author Ihor Savchenko
 * @version 1.0
 */
public class Taxi extends BaseLogger {

    static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {

        logger.info("Enter the number of a group of a people");
        int numberGroup = scn.nextInt();
        logger.info("Enter the number of a person (greater than 0, less than or equal to 4) in each group");
        int[] personInGroup = new int[numberGroup];
        for (int i = 0; i < numberGroup; i++){
            personInGroup[i] = scn.nextInt();
        }

        Arrays.sort(personInGroup);

        int index = 0;
        for(int i = numberGroup-1; i >= 0; i--){
            if(personInGroup[i] != 4){
                index = i + 1;
                break;
            }
        }

        int result = numberGroup - index;

        int index2 = 0;
        for(int i = index-1; i >= 0; i--){
            if(personInGroup[i] != 3){
                index2 = i + 1;
                break;
            }
        }

        int numberOfThree = index - index2;

        int index3 = 0;
        for(int i = index2-1; i >= 0; i--){
            if(personInGroup[i] != 2){
                index3 = i + 1;
                break;
            }
        }

        int numberOfTwo = index2 - index3;
        int numberOfOne = 0;
        if(index3 != 0) numberOfOne = index3;

        if(numberOfTwo != 0 && numberOfTwo % 2 == 0){
            result = result + numberOfTwo/2;
            numberOfTwo = 0;
        } else if(numberOfTwo > 0) {
            result = result + numberOfTwo/2;
            numberOfTwo = 1;
        }

        if(numberOfOne != 0 && numberOfTwo == 1){
            result = result + 1;
            numberOfTwo = 0;
            numberOfOne = numberOfOne - 1;
        }

        if(numberOfThree <= numberOfOne){
            result = result + numberOfThree;
            numberOfOne = numberOfOne - numberOfThree;
            numberOfThree = 0;
        } else {
            result = result + numberOfOne;
            numberOfThree = numberOfThree - numberOfOne;
            numberOfOne = 0;
        }

        if(numberOfOne != 0 && numberOfOne/4 > 0){
            result = result + numberOfOne/4 + 1;
        } else if(numberOfOne > 0){
            result = result + 1;
        }

        result = result + numberOfTwo + numberOfThree;

        logger.info(String.valueOf(numberGroup));
        logger.info(Arrays.toString(personInGroup));
        logger.info(String.valueOf(result));
        logger.info("NumberOfThree: " + String.valueOf(numberOfThree));
        logger.info("NumberOfTwo: " + String.valueOf(numberOfTwo));
        logger.info("NumberOfOne: " + String.valueOf(numberOfOne));
    }
}
