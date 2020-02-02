package ua.examples.practice.practice4;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 implements Iterable {

	private static final String CHARSET = Charset.forName("cp1251").displayName();
	private static final String FILE = "part44.txt";
	static Matcher matcher = null;

	public static void main(String[] args) {

		String input = getInput(FILE, CHARSET);
		Pattern pattern = Pattern.compile("(?U)([\\p{javaUpperCase}]([\\w\\s" + System.lineSeparator() + ",]+)\\.)");
		matcher = pattern.matcher(input);
		Iterator iterator = new Part4().iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	@Override
	public Iterator iterator() {

		return new Iterator() {

			@Override
			public boolean hasNext() {

				if(matcher.find()){
					return true;
				}
				else{
					return false;
				}
			}
			@Override
			public Object next() {

				String s = matcher.group(1);
				Pattern pattern3 = Pattern.compile(System.lineSeparator());
				Matcher matcher3 = pattern3.matcher(s);
				String inputNew = matcher3.replaceAll("");
				return inputNew.trim();
			}
		};
	}

	public static String getInput(String fileName, String charset) {

		StringBuilder sb = new StringBuilder();
		try(Scanner scanner = new Scanner(new File(fileName), charset)) {
			while (scanner.hasNextLine()) {
				String temp = scanner.nextLine();
				sb.append(temp).append(System.lineSeparator());
			}
			return sb.toString().trim();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return sb.toString().trim();
	}
}
