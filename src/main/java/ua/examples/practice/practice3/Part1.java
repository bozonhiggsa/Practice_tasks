package ua.examples.practice.practice3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

	public static void main(String[] args) {

		String input = Util.getInput("part1.txt");

		System.out.print("-----------------------");
		System.out.println(Part1.convert1(input));
		System.out.println("-----------------------");
		System.out.print("-----------------------");
		System.out.println(Part1.convert2(input));
		System.out.println("-----------------------");
		System.out.print("-----------------------");
		System.out.println(Part1.convert3(input));
		System.out.println("-----------------------");
		System.out.println(Part1.convert4(input));
		System.out.println("-----------------------");
	}

	private static String convert1(String input) {
		Pattern pattern = Pattern.compile("(?Um)^(\\w+);(\\w+\\s.+);((\\w+)@(\\w+)\\.(\\w+))$");
		Matcher matcher = pattern.matcher(input);
		String lineSeparator = System.lineSeparator();
		String result = "";

		while(matcher.find()) {
			result =  result + lineSeparator + matcher.group(1) + " ==> " + matcher.group(3);
		}
		return result;
	}

	private static String convert2(String input) {
		Pattern pattern = Pattern.compile("(?Um)^(\\w+);(\\w+)\\s(\\w+);((\\w+)@(\\w+)\\.(\\w+))$");
		Matcher matcher = pattern.matcher(input);
		String lineSeparator = System.lineSeparator();
		String result = "";

		while(matcher.find()) {
			result =  result + lineSeparator + matcher.group(3) + " " + matcher.group(2) + " (email: " + matcher.group(4) + ")";
		}
		return result;
	}
	private static String convert3(String input) {
		String lineSeparator = System.lineSeparator();
		String result = "";
		String result2 = "";
		List<String> list = new ArrayList<>();
		Pattern pattern = Pattern.compile("(?Um)^(\\w+);(\\w+)\\s(\\w+);((\\w+)@((\\w+)\\.(\\w+)))$");
		Matcher matcher = pattern.matcher(input);
		while(matcher.find()) {
			if(!list.contains(matcher.group(6))){
				list.add(matcher.group(6));
			}
		}
		matcher.reset();

		List<String> list2 = new ArrayList<>();


		for (String element: list) {
			list2.add(element + " ==> ");
		}

		for(String domen: list2) {
			result2 = lineSeparator + domen;
			while(matcher.find()) {
				if(domen.contains(matcher.group(6))){
					result2 =  result2 + matcher.group(1) + ", ";
				}
			}
			result2 = result2.substring(0, result2.length() - 2);
			result = result + result2;
			matcher.reset();
		}
		return result;

	}

	private static String convert4(String input) {
		String lineSeparator = System.lineSeparator();
		Pattern pattern1 = Pattern.compile("(?m)^(\\w+);(\\w+);(\\w+)$");
		Pattern pattern2 = Pattern.compile("(?Um)^(\\w+);(\\w+\\s.+);((\\w+)@(\\w+)\\.(\\w+))$");
		Matcher matcher1 = pattern1.matcher(input);
		Matcher matcher2 = pattern2.matcher(input);
		String result = "";
		int count = 0;

		while(matcher1.find()) {
			result =  result + matcher1.group(0) + ";Password" + lineSeparator;
		}
		while(matcher2.find()) {
			result =  result + matcher2.group(0) + ";"
					+ (int)(Math.random()*10) + (int)(Math.random()*10) + (int)(Math.random()*10) + (int)(Math.random()*10) + lineSeparator;
			count++;
		}

		if(count == 4){
			return result.trim();
		}
		else {
			return result;
		}
	}
}
