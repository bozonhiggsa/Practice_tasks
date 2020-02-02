package ua.examples.practice.practice5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Spam {

    private String[] messages;
    private int[] time;
    private static Thread[] threads;
    private static int numberThread;

    public static void main(String[] args) throws InterruptedException {
        Spam spam = new Spam(
                new String[]{"@@@", "bbbbbbb"}, new int[]{333, 222}
        );
        numberThread = spam.messages.length;
        threads = new Thread[numberThread];
        for(int i = 0; i < numberThread; i++){
            threads[i] = new Worker(spam.messages[i], spam.time[i]);
        }
        start(threads, numberThread);
        Thread.sleep(2000);
        String nextString = null;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while(!(nextString = reader.readLine()).equals("")){}
            stop();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void start(Thread[] threads, int numberThread){
        for(int i = 0; i < numberThread; i++){
            threads[i].start();
        }
    }

    public static void stop(){
        for(int i = 0; i < numberThread; i++){
            threads[i].interrupt();
        }
    }


    public Spam(String[] messages, int[] time) {
        this.messages = messages;
        this.time = time;
    }

    private static class Worker extends Thread {
        private String message;
        private int timeout;

        public Worker(String message, int timeout) {
            this.message = message;
            this.timeout = timeout;
        }

        @Override
        public void run() {
            try{
                while(true){
                    if(isInterrupted()){
                        return;
                    }
                    System.out.println(message);
                    Thread.sleep(timeout);
                }
            }
            catch(InterruptedException e){
                return;
            }
        }
    }
}
