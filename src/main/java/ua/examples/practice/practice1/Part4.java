package ua.examples.practice.practice1;

public class Part4 {

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
        if(mark){
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);
            int maxDivider = 1;

            int min = Math.min(num1, num2);
            for(int i = 2; i <= min; i++){
                if((num1%i == 0)&&(num2%i == 0)){
                    maxDivider = i;
                    //break;
                }
            }
            System.out.println(maxDivider);
        }
    }
}
