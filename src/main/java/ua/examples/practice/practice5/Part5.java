package ua.examples.practice.practice5;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Part5 {

    private static final String FILE = "part55.txt";
    private static final int stringLength = 20;
    private static final int numberOfThreads = 10;
    private static byte[] separatorBytes;

    public static void main(String[] args) throws InterruptedException, IOException {

        String lineSeparator = System.lineSeparator();
        separatorBytes = lineSeparator.getBytes();
        int separatorLength = lineSeparator.length();

        (new File(FILE)).delete();

        RandomAccessFile file = new RandomAccessFile(FILE, "rw");

        Object monitor = new Object();
        Thread[] threads = new Thread[numberOfThreads];
        for(int i = 0; i < numberOfThreads; i++){
            threads[i] = new ThreadImpl(monitor, file, stringLength, separatorLength, i);
        }
        for(int i = 0; i < numberOfThreads; i++){
            threads[i].start();
        }
        for(int i = 0; i < numberOfThreads; i++){
            threads[i].join();
        }
        for(int i = 0; i < numberOfThreads; i++){
            file.seek(i * (stringLength + separatorLength));
            System.out.println(file.readLine());
        }
        file.close();    }

    private static class ThreadImpl extends Thread {
        private Object monitor;
        private RandomAccessFile file;
        private int stringLength;
        private int separatorLength;
        private int threadIndex;

        public ThreadImpl(Object monitor, RandomAccessFile file, int stringLength, int separatorLength, int threadIndex) {
            this.monitor = monitor;
            this.file = file;
            this.stringLength = stringLength;
            this.separatorLength = separatorLength;
            this.threadIndex = threadIndex;
        }

        public void run() {
            int start = threadIndex * (stringLength + separatorLength);
            int digit = '0' + threadIndex;
            synchronized (monitor) {
                try {
                    for(int i = start; i < (start + stringLength); i++){
                        file.seek(i);
                        file.write(digit);
                        monitor.wait(1);
                    }
                    if(threadIndex != (numberOfThreads - 1)){
                        for(int i = (start + stringLength); i < (start + stringLength + separatorLength); i++){
                            file.seek(i);
                            file.write(separatorBytes[(i - (start + stringLength))]);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
