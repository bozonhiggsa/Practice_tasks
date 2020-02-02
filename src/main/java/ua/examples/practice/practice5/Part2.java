package ua.examples.practice.practice5;

import java.io.IOException;
import java.io.InputStream;

public class Part2 {

    public static void main(String[] args) throws InterruptedException {
       System.setIn(new MyInputStream());
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    Spam.main(null);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        thread.join();
        System.setIn(System.in);
    }

    public static class MyInputStream extends InputStream {

        private String lineSeparator = System.lineSeparator();
        private int numberSymbol = 0;
        public int read() throws IOException {
            byte[] bytes = lineSeparator.getBytes();
            if(numberSymbol < lineSeparator.length()){
                return lineSeparator.getBytes()[numberSymbol];
            }
            else{
                return -1;
            }
        }
    }
}
