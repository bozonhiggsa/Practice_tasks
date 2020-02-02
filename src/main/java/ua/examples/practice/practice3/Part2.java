package ua.examples.practice.practice3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

	public static void main(String[] args) {
		String input = Util.getInput("part2.txt");
		System.out.println("-----------------------");
		System.out.println(Part2.convert(input));
		System.out.println("-----------------------");
	}

	public static String convert(String input) {
		Pattern pattern = Pattern.compile("(?U)\\b([\\w&&[\\D]&&[^_]]+)\\b");
		Matcher matcher = pattern.matcher(input);
		String lineSeparator = System.lineSeparator();
		String minString = "Min: ";
		String maxString = "Max: ";

		int min = 20;
		int max = 0;

		while(matcher.find()) {
			if(matcher.group(1).length() < min){
				min = matcher.group(1).length();
			}
			if(matcher.group(1).length() > max){
				max = matcher.group(1).length();
			}
		}

		matcher.reset();

		while(matcher.find()) {
			if(matcher.group(1).length() == min && (!minString.contains(matcher.group(1)))){
				minString = minString + matcher.group(1) + ", ";
			}
			if(matcher.group(1).length() == max && (!maxString.contains(matcher.group(1)))){
				maxString = maxString + matcher.group(1) + ", ";
			}
		}
		minString = minString.substring(0, minString.length()-2);
		maxString = maxString.substring(0, maxString.length()-2);
		return minString + lineSeparator + maxString;
	}
}
