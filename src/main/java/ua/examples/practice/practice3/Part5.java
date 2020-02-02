package ua.examples.practice.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part5 {

	public static void main(String[] args) {

		System.out.println("-----------------------");
		System.out.println(1 + " ===> " + decimal2Roman(1) + " ===> " + roman2Decimal(decimal2Roman(1)));
		System.out.println(2 + " ===> " + decimal2Roman(2) + " ===> " + roman2Decimal(decimal2Roman(2)));
		System.out.println(3 + " ===> " + decimal2Roman(3) + " ===> " + roman2Decimal(decimal2Roman(3)));
		System.out.println(4 + " ===> " + decimal2Roman(4) + " ===> " + roman2Decimal(decimal2Roman(4)));
		System.out.println(5 + " ===> " + decimal2Roman(5) + " ===> " + roman2Decimal(decimal2Roman(5)));
		System.out.println();
		System.out.println(94 + " ===> " + decimal2Roman(94) + " ===> " + roman2Decimal(decimal2Roman(94)));
		System.out.println(95 + " ===> " + decimal2Roman(95) + " ===> " + roman2Decimal(decimal2Roman(95)));
		System.out.println(96 + " ===> " + decimal2Roman(96) + " ===> " + roman2Decimal(decimal2Roman(96)));
		System.out.println(97 + " ===> " + decimal2Roman(97) + " ===> " + roman2Decimal(decimal2Roman(97)));
		System.out.println(98 + " ===> " + decimal2Roman(98) + " ===> " + roman2Decimal(decimal2Roman(98)));
		System.out.println(99 + " ===> " + decimal2Roman(99) + " ===> " + roman2Decimal(decimal2Roman(99)));
		System.out.println(49 + " ===> " + decimal2Roman(49) + " ===> " + roman2Decimal(decimal2Roman(49)));
		System.out.println(19 + " ===> " + decimal2Roman(19) + " ===> " + roman2Decimal(decimal2Roman(19)));
		System.out.println(29 + " ===> " + decimal2Roman(29) + " ===> " + roman2Decimal(decimal2Roman(29)));
		System.out.println(39 + " ===> " + decimal2Roman(39) + " ===> " + roman2Decimal(decimal2Roman(39)));
		System.out.println(59 + " ===> " + decimal2Roman(59) + " ===> " + roman2Decimal(decimal2Roman(59)));
		System.out.println(69 + " ===> " + decimal2Roman(69) + " ===> " + roman2Decimal(decimal2Roman(69)));
		System.out.println(79 + " ===> " + decimal2Roman(79) + " ===> " + roman2Decimal(decimal2Roman(79)));
		System.out.println(89 + " ===> " + decimal2Roman(89) + " ===> " + roman2Decimal(decimal2Roman(89)));
		System.out.println("-----------------------");
	}

	public static String decimal2Roman(int x) {

		String inputString = String.valueOf(x);
		Pattern pattern1 = Pattern.compile("[\\d]{3}");
		Matcher matcher1 = pattern1.matcher(inputString);
		if(matcher1.matches()) {
			return "C";
		}

		Pattern pattern2 = Pattern.compile("[\\d]");
		Matcher matcher2 = pattern2.matcher(inputString);
		if(matcher2.matches()) {
			return tailRoman(x);
		}

		Pattern pattern3 = Pattern.compile("[\\d]{2}");
		Matcher matcher3 = pattern3.matcher(inputString);
		if(matcher3.matches()) {
			int forward = x/10;
			int tail = x%10;
			return forwardRoman(forward) + tailRoman(tail);
		}
		return null;
	}

	public static int roman2Decimal(String s) {

		if(s.equals("C")){
			return 100;
		}

		Pattern pattern1 = Pattern.compile("[IV]([IVX]*)");
		Matcher matcher1 = pattern1.matcher(s);
		if(matcher1.matches()) {
			return tailDecimal(s);
		}

		Pattern pattern2 = Pattern.compile("([XLC]+)(IX)");
		Matcher matcher2 = pattern2.matcher(s);
		if(matcher2.find()) {
			return Integer.parseInt(forwardDecimal(matcher2.group(1)) + "" + tailDecimal(matcher2.group(2)));
		}

		Pattern pattern3 = Pattern.compile("([XLC]+)([IV]*)");
		Matcher matcher3 = pattern3.matcher(s);
		if(matcher3.find()) {
			return Integer.parseInt(forwardDecimal(matcher3.group(1)) + "" + tailDecimal(matcher3.group(2)));
		}

		return 0;
	}

	private static String tailRoman(int x) {
		String tailResult = "";
		switch (x){
			case 1:
				tailResult = "I";
				break;
			case 2:
				tailResult = "II";
				break;
			case 3:
				tailResult = "III";
				break;
			case 4:
				tailResult = "IV";
				break;
			case 5:
				tailResult = "V";
				break;
			case 6:
				tailResult = "VI";
				break;
			case 7:
				tailResult = "VII";
				break;
			case 8:
				tailResult = "VIII";
				break;
			case 9:
				tailResult = "IX";
				break;
		}
		return tailResult;
	}

	private static String forwardRoman(int x) {
		String forwardResult = "";
		switch (x){
			case 1:
				forwardResult = "X";
				break;
			case 2:
				forwardResult = "XX";
				break;
			case 3:
				forwardResult = "XXX";
				break;
			case 4:
				forwardResult = "XL";
				break;
			case 5:
				forwardResult = "L";
				break;
			case 6:
				forwardResult = "LX";
				break;
			case 7:
				forwardResult = "LXX";
				break;
			case 8:
				forwardResult = "LXXX";
				break;
			case 9:
				forwardResult = "XC";
				break;
		}
		return forwardResult;
	}

	private static int tailDecimal(String s) {
		int tailResult = 0;
		switch (s){
			case "I":
				tailResult = 1;
				break;
			case "II":
				tailResult = 2;
				break;
			case "III":
				tailResult = 3;
				break;
			case "IV":
				tailResult = 4;
				break;
			case "V":
				tailResult = 5;
				break;
			case "VI":
				tailResult = 6;
				break;
			case "VII":
				tailResult = 7;
				break;
			case "VIII":
				tailResult = 8;
				break;
			case "IX":
				tailResult = 9;
				break;
		}
		return tailResult;
	}

	private static int forwardDecimal(String s) {
		int forwardResult = 0;
		switch (s){
			case "X":
				forwardResult = 1;
				break;
			case "XX":
				forwardResult = 2;
				break;
			case "XXX":
				forwardResult = 3;
				break;
			case "XL":
				forwardResult = 4;
				break;
			case "L":
				forwardResult = 5;
				break;
			case "LX":
				forwardResult = 6;
				break;
			case "LXX":
				forwardResult = 7;
				break;
			case "LXXX":
				forwardResult = 8;
				break;
			case "XC":
				forwardResult = 9;
				break;
		}
		return forwardResult;
	}
}
