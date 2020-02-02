package ua.examples.practice.practice1;

public class Part7 {

    public static void main(String[] args) {

        System.out.println("A ==> " + str2int("A") + " ==> " + int2str(str2int("A")));
        System.out.println("B ==> " + str2int("B") + " ==> " + int2str(str2int("B")));
        System.out.println("Z ==> " + str2int("Z") + " ==> " + int2str(str2int("Z")));
        System.out.println("AA ==> " + str2int("AA") + " ==> " + int2str(str2int("AA")));
        System.out.println("AZ ==> " + str2int("AZ") + " ==> " + int2str(str2int("AZ")));
        System.out.println("BA ==> " + str2int("BA") + " ==> " + int2str(str2int("BA")));
        System.out.println("ZZ ==> " + str2int("ZZ") + " ==> " + int2str(str2int("ZZ")));
        System.out.println("AAA ==> " + str2int("AAA") + " ==> " + int2str(str2int("AAA")));
    }

    public static int str2int(String number){
        for(int i = 0; i < number.length(); i++) {
            if (number.charAt(i) < 65 || number.charAt(i) > 90) {
                System.out.println("Please, enter only the uppercase symbols from 'A' to 'Z'");
                return -1;
            }
        }
        int numberOfChars = number.length();
        int[] codepoints = new int[numberOfChars];
        int[] nums = new int[numberOfChars];
        for(int i = 0; i < numberOfChars; i++){
            codepoints[i] = number.charAt(i);
            nums[i] = codepoints[i] - 64;
        }
        int result = nums[numberOfChars - 1];
        for(int i = 0; i < numberOfChars-1; i++){
            result = (int)(result + nums[i]* Math.pow(26,(numberOfChars - 1 - i)));
        }
        return result;
    }

    public static String int2str(int number){
        if(number <= 0){
            System.out.println("Please, enter the positive number");
            return "";
        }
        int numberOfChars = evaluateNumberOfChars(number);
        char[] chars = new char[numberOfChars];

        for(int i = (numberOfChars - 1); i >= 0; i--){
            if (number % 26 != 0) {
                chars[i] = (char) (number % 26 + 64);
                number = (number - (number % 26))/26;
            } else {
                chars[i] = 'Z';
                number = (number/26) - 1;
            }
        }
        return new String(chars);
    }

    private static int evaluateNumberOfChars(int code){
        int accumulator = 26;
        int power = 2;
        int numberOfChars = 0;
        while(true){
            if(code <= accumulator){
                numberOfChars+=1;
                break;
            }
            else{
                accumulator = accumulator + (int)(Math.pow(26, power));
                numberOfChars+=1;
                power++;
            }
        }
        return numberOfChars;
    }

    public static String rightColumn(String number){
        for(int i = 0; i < number.length(); i++) {
            if (number.charAt(i) < 65 || number.charAt(i) > 90) {
                System.out.println("Please, enter the uppercase symbols from 'A' to 'Z'");
                return "";
            }
        }
        return int2str(str2int(number) + 1);
    }
}