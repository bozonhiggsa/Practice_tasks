package ua.examples.practice.practice5;

public class Part4 {

    public static void main(String[] args) throws InterruptedException {

        int[][] arrayNumbers = Util.readIntArray();
        int numberOfThreads = arrayNumbers.length;
        int[] result1 = new int[numberOfThreads];
        Thread[] threads = new Thread[numberOfThreads];
        for(int i = 0; i < numberOfThreads; i++){
            threads[i] = new ThreadImpl(arrayNumbers, result1, i);
        }
        long start1 = System.currentTimeMillis();
        for(int i = 0; i < numberOfThreads; i++){
            threads[i].start();
        }
        for(int i = 0; i < numberOfThreads; i++){
            threads[i].join();
        }
        long stop1 = System.currentTimeMillis();
        int maximum1 = 0;
        for(int num: result1){
            if(num > maximum1){
                maximum1 = num;
            }
        }
        System.out.println(maximum1);
        System.out.println(stop1 - start1);
        int[] result2 = new int[numberOfThreads];
        long start2 = System.currentTimeMillis();
        sequentionalDecision(arrayNumbers, result2);
        long stop2 = System.currentTimeMillis();
        int maximum2 = 0;
        for(int num: result2){
            if(num > maximum2){
                maximum2 = num;
            }
        }
        System.out.println(maximum2);
        System.out.println(stop2 - start2);
    }

    private static class ThreadImpl extends Thread {
        private int[][] arr;
        private int[] result;
        private int threadIndex;

        public ThreadImpl(int[][] arr, int[] result, int threadIndex) {
            this.arr = arr;
            this.result = result;
            this.threadIndex = threadIndex;
        }

        public void run() {
                result[threadIndex] = searchMaximum(arr[threadIndex]);
        }
    }

    private static int searchMaximum(int[] vector){
        try {
            for(int i = 1; i < vector.length; i++){
                if(vector[i-1] > vector[i]){
                    vector[i] = vector[i-1];
                }
                Thread.sleep(1);
            }
            return vector[vector.length - 1];

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static void sequentionalDecision(int[][] arr, int[] result){
        for(int i = 0; i < arr.length; i++){
            result[i] = searchMaximum(arr[i]);
        }
    }
}
