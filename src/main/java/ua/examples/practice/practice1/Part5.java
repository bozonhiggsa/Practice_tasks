package ua.examples.practice.practice1;

public class Part5 {

    public static void main(String[] args) {

        Boolean mark = true;
        if(args == null || args[0] == null){
            System.out.println("You cannot use the argument equals Null");
            mark = false;
        }
        if(mark){
            if(args.length != 1){
                System.out.println("There is not 1 argument");
                mark = false;
            }
        }
        if(mark) {
            String arg = args[0];
            for (int i = 0; i < arg.length(); i++) {
                char ch = arg.charAt(i);
                if (!Character.isDigit(ch)) {
                    System.out.println("You must enter the positive natural number!");
                    mark = false;
                    break;
                }
            }
        }
        if(mark) {
            String arg = args[0];
            int sum = 0;
            for (int i = 0; i < arg.length(); i++) {
                sum = sum + Integer.parseInt(new String(new char[]{arg.charAt(i)}));
            }
            System.out.println(sum);
        }
    }
}
