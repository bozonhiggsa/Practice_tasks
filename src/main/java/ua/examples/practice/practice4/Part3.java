package ua.examples.practice.practice4;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

	private static final String ENCODING = "cp1251";
	private static final String FILE = "part43.txt";

	public static void main(String[] args) {

		String stringResult = read(FILE, ENCODING);
		Pattern patternChar = Pattern.compile("(?U)\\b([\\w&&[\\D]&&[^_]])\\b");
		Pattern patternString = Pattern.compile("(?U)\\b([\\w&&[\\D]&&[^_]][\\w&&[\\D]&&[^_]]+)\\b");
		Pattern patternDouble = Pattern.compile("([\\s]?([\\.]?[\\d\\.]+)[\\s]?)");
		Matcher matcherChar = patternChar.matcher(stringResult);
		Matcher matcherString = patternString.matcher(stringResult);
		Matcher matcherDouble = patternDouble.matcher(stringResult);
		String query = "";
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, ENCODING))) {
			while(!(query = reader.readLine()).equals("stop")){
				StringBuilder builder = new StringBuilder();
				if(query.equals("char")){
					while(matcherChar.find()) {
						builder.append(matcherChar.group(1)).append(" ");
					}
					matcherChar.reset();
					String result = builder.toString();
					if(!result.isEmpty()){
						System.out.println(result.trim());
					}
				}
				else if(query.equals("String")){
					while(matcherString.find()) {
						builder.append(matcherString.group(1)).append(" ");
					}
					matcherString.reset();
					String result = builder.toString();
					if(!result.isEmpty()){
						System.out.println(result.trim());
					}
				}
				else if(query.equals("double")){
					while(matcherDouble.find()) {
						if(matcherDouble.group(1).contains(".")){
							builder.append(matcherDouble.group(2)).append(" ");
						}
					}
					matcherDouble.reset();
					String result = builder.toString();
					if(!result.isEmpty()){
						System.out.println(result.trim());
					}
				}
				else if(query.equals("int")){
					while(matcherDouble.find()) {
						if(!matcherDouble.group(1).contains(".")){
							builder.append(matcherDouble.group(2)).append(" ");
						}
					}
					matcherDouble.reset();
					String result = builder.toString();
					if(!result.isEmpty()){
						System.out.println(result.trim());
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String read(String fileName, String encoding) {

		StringBuffer bf = new StringBuffer();
		String nextString = "";
		try(InputStream is = new FileInputStream(fileName);
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, encoding))) {
			while((nextString = reader.readLine()) != null){
				bf.append(nextString);
			}
			return bf.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bf.toString();
	}
}