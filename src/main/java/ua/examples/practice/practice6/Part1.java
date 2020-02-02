package ua.examples.practice.practice6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {

	private static final String ENCODING = "UTF-8";

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		String input = "";
		try(Scanner scan = new Scanner(System.in, ENCODING)) {
			while (scan.hasNext()) {
				input = scan.next();
				if (input.equals("stop")) {
					break;
				} else {
					list.add(input);
				}
			}
		}
		WordContainer.main(list.toArray(new String[0]));
	}
}