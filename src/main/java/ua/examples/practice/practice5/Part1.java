package ua.examples.practice.practice5;

public class Part1 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new ThreadImpl("thread A", 500);
        Thread thread2 = new Thread(new RunnableImpl("thread B", 500));
        thread1.start();
        thread1.join();
        thread2.start();
    }

    public static class ThreadImpl extends Thread {
        private String name;
        private int timeout;

        public ThreadImpl(String name, int timeout) {
            this.name = name;
            this.timeout = timeout;
        }

        public void run() {
            try{
                for(int i = 0; i < 4; i++){
                    System.out.println(name);
                    Thread.sleep(timeout);
                }
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static class RunnableImpl implements Runnable {
        private String name;
        private int timeout;

        public RunnableImpl(String name, int timeout) {
            this.name = name;
            this.timeout = timeout;
        }


        public void run() {
            try{
                for(int i = 0; i < 4; i++){
                    System.out.println(name);
                    Thread.sleep(timeout);
                }
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
