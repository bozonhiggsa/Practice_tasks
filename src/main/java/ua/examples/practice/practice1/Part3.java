package ua.examples.practice.practice1;

public class Part3 {
    public static void main(String[] args) {

        Boolean mark = true;
        if(args == null){
            System.out.println("You cannot use the argument equals Null");
            mark = false;
        }
        if(mark) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i] + " ");
            }
        }
    }
}
