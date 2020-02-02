package ua.examples.practice.practice5;

import java.io.IOException;

/**
 * Entry Point
 * @author Ihor Savchenko
 * @version 1.0
 */

public class Demo {

    public static void main(String[] args) throws InterruptedException, IOException {

        System.out.println("=========================== PART1");
        Part1.main(args);
        Thread.sleep(2000);

        System.out.println("=========================== PART2");
        Part2.main(args);

        System.out.println("=========================== PART3");
        Part3.main(args);
        Thread.sleep(2000);

        System.out.println("=========================== PART4");
        Part4.main(args);

        System.out.println("=========================== PART5");
        Part5.main(args);
    }
}

