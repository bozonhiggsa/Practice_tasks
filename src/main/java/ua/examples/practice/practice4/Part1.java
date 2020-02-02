package ua.examples.practice.practice4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

	private static final String CHARSET = "cp1251";
	private static final String FILE = "part41.txt";

	public static void main(String[] args) {

		String input = getInput(FILE, CHARSET);
		Pattern pattern1 = Pattern.compile("(?m)^(.+)$");
		Pattern pattern2 = Pattern.compile("(?U)(\\(?<?\\b([[\\w-]&&[^_]]+)\\b,?\\.?!?\\)?>?\\??(\\s-)?(\\s)?)");
		Matcher matcher1 = pattern1.matcher(input);
		Matcher matcher2 = null;
		String resultString = "";
		String lineSeparator = System.lineSeparator();

		while(matcher1.find()) {
			matcher2 = pattern2.matcher(matcher1.group(1));
			StringBuilder result = new StringBuilder();
			while(matcher2.find()) {
				if(matcher2.group(2).length() < 4 | (matcher2.group(2).contains("-") && matcher2.group(2).length() < 9)){
					result.append(matcher2.group(1));
				}
				else{
					result.append(matcher2.group(1).toUpperCase());
				}
			}
			String resultStr = result.toString();
			resultString = resultString + resultStr + lineSeparator;
		}

		System.out.println(resultString.trim());
	}

	public static String getInput(String fileName, String charset) {

		StringBuilder sb = new StringBuilder();
		try(Scanner scanner = new Scanner(new File(fileName), charset)) {
			while (scanner.hasNextLine()) {
				sb.append(scanner.nextLine()).append(System.lineSeparator());
			}
			return sb.toString().trim();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return sb.toString();
	}
}
