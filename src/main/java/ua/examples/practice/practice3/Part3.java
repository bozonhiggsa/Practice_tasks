package ua.examples.practice.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

	public static void main(String[] args) {
		String input = Util.getInput("part3.txt");
		System.out.println("-----------------------");
		System.out.println(Part3.convert(input));
		System.out.println("-----------------------");
	}

	public static String convert(String input) {
		Pattern pattern1 = Pattern.compile("(?m)^(.+)$");
		Pattern pattern2 = Pattern.compile("(?U)(\\b([\\w&&[\\D]&&[^_]]+)\\b,?)");
		Matcher matcher1 = pattern1.matcher(input);
		Matcher matcher2 = null;
		String resultString = "";
		String lineSeparator = System.lineSeparator();
		while(matcher1.find()) {
			matcher2 = pattern2.matcher(matcher1.group(1));
			StringBuilder result = new StringBuilder();
			while(matcher2.find()) {
				if(matcher2.group(2).length() < 3){
					result.append(matcher2.group(1) + " ");
				}
				else{
					char firstLitera = matcher2.group(1).charAt(0);
					char firstLiteraUpperCase = Character.toUpperCase(firstLitera);
					result.append(matcher2.group(1).replaceFirst(Character.toString(firstLitera),
							Character.toString(firstLiteraUpperCase)) + " ");
				}
			}
			resultString = resultString + result.toString().trim() + lineSeparator;
		}

		return resultString.substring(0, resultString.length()-1);
	}
}
