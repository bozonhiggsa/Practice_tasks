package ua.examples.practice.practice1;

public class Part2 {

    public static void main(String[] args) {

        Boolean mark = true;
        if(args == null || args[0] == null || args[1] == null){
            System.out.println("You cannot use the argument equals Null");
            mark = false;
        }
        if(mark){
            if(args.length != 2){
                System.out.println("There are not 2 arguments");
                mark = false;
            }
        }
        if(mark) {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            System.out.println(a + b);
        }
    }
}
