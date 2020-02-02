package ua.examples.practice.practice5;

public class Part3 {
    private static int counter1;
    private static int counter2;
    private static final int TIMEOUT = 10;
    private static final int LIMIT = 10;

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new ThreadImpl_1(LIMIT, TIMEOUT);
        Thread thread2 = new ThreadImpl_1(LIMIT, TIMEOUT);
        Thread thread3 = new ThreadImpl_1(LIMIT, TIMEOUT);
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();

        counter1 = 0;
        counter2 = 0;
        Object monitor = new Object();
        Thread thread4 = new ThreadImpl_2(LIMIT, TIMEOUT, monitor);
        Thread thread5 = new ThreadImpl_2(LIMIT, TIMEOUT, monitor);
        Thread thread6 = new ThreadImpl_2(LIMIT, TIMEOUT, monitor);
        thread4.start();
        thread5.start();
        thread6.start();
    }

    public static class ThreadImpl_1 extends Thread {
        private int timeout;
        private int limit;

        public ThreadImpl_1(int limit, int timeout) {
            this.limit = limit;
            this.timeout = timeout;
        }

        @Override
        public void run() {
            for(int i = 0; i < limit; i++){
                System.out.println("counter1 equal counter2: " + (counter1 == counter2));
                counter1++;
                try {
                    Thread.sleep(timeout);
                    counter2++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class ThreadImpl_2 extends Thread {
        private int timeout;
        private int limit;
        private Object monitor;

        public ThreadImpl_2(int limit, int timeout, Object monitor) {
            this.limit = limit;
            this.timeout = timeout;
            this.monitor = monitor;
        }

        @Override
        public void run() {
            for(int i = 0; i < limit; i++){
                synchronized (monitor){
                    System.out.println("counter1 equal counter2: " + (counter1 == counter2));
                    counter1++;
                    try {
                        Thread.sleep(timeout);
                        counter2++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
