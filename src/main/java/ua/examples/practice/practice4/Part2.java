package ua.examples.practice.practice4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

	private static final String ENCODING = "UTF-8";
	private static final String FILE1 = "part42.txt";
	private static final String FILE2 = "part42_sorted.txt";
	private static final int COUNT = 10;

	public static void main(String[] args) {

		int[] a = createArray(COUNT);
		String stringA = "";
		for (int number: a) {
			stringA = stringA + number + " ";
		}

		writeToFile(FILE1, stringA, ENCODING);

		String stringResult = read(FILE1, ENCODING);
		Pattern pattern = Pattern.compile("\\b([\\w]+)\\b");
		Matcher matcher = pattern.matcher(stringResult);
		int[] b = new int[COUNT];
		int index = 0;
		while(matcher.find()) {
			b[index] = Integer.parseInt(matcher.group(1));
			index++;
		}

		sort(b);

		String stringB = "";
		for (int number: b) {
			stringB = stringB + number + " ";
		}

		writeToFile(FILE2, stringB, ENCODING);

		System.out.println("input ==> " + read(FILE1, ENCODING));
		System.out.println("output ==> " + read(FILE2, ENCODING));
	}

	private static int[] createArray(int count){

		int[] a = new int[count];
		for(int i = 0; i < count; i++){
			a[i] = (int) (Math.random()*50);
		}
		return a;
	}

	public static String read(String fileName, String encoding) {

		StringBuilder builder = new StringBuilder();
		String nextString = "";
		try(InputStream is = new FileInputStream(fileName);
			BufferedReader reader =
					new BufferedReader(new InputStreamReader(is, encoding))) {
			while((nextString = reader.readLine()) != null){
				builder.append(nextString);
			}
			return builder.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder.toString().trim();
	}

	public static void writeToFile(String fileName, String message, String encoding) {

		try(OutputStream os = new FileOutputStream(fileName);
			Writer osw = new OutputStreamWriter(os, encoding)) {
			osw.write(message);
			osw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int[] readIntArray(String fileName, String encoding) {

		List<Integer> list = new ArrayList<>();
		try(Scanner scanner = new Scanner(new File(fileName), encoding)) {
			while (scanner.hasNext()) {
				if (scanner.hasNextInt()) {
					list.add(scanner.nextInt());
				} else {
					System.out.println(scanner.next());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int[] intArray = new int[list.size()];
		for(int i = intArray.length-1; i >= 0; i--){
			intArray[i] = list.remove(i);
		}
		return intArray;
	}

	public static int[] sort(int[] array) {

		int currentLength = array.length;
		while(currentLength > 1) {
			int currentIndex = 0;
			while (currentIndex < currentLength - 1) {
				int temp = array[currentIndex];
				if (array[currentIndex] > array[currentIndex + 1]) {
					array[currentIndex] = array[currentIndex + 1];
					array[currentIndex + 1] = temp;
				}
				currentIndex++;
			}
			currentLength -= 1;
		}
		return array;
	}
}