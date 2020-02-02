package ua.examples.practice.practice1;

public class Part6 {

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

        if(mark){
            String arg = args[0];
            int arr_length = Integer.parseInt(arg);
            int[] arr = new int[arr_length];
            arr[0] = 2;

            if(arr_length > 1) {
                int x = 3;
                int index = 1;

                while (true) {
                    if (ifSimpleNumber(x)) {
                        arr[index] = x;
                        index++;
                    }
                    x++;
                    if (index == arr_length) break;
                }
            }
            for (int element: arr) {
                System.out.print(element + " ");
            }
        }
    }

    public static boolean ifSimpleNumber(int number) {

        boolean decision = true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                decision = false;
            }
        }
        return decision;
    }
}
