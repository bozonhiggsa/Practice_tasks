package ua.examples.practice.practice3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 {
	public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance(algorithm);
		digest.update(input.getBytes());
		byte[] hash = digest.digest();
		String[] hashHexString = new String[hash.length];
		for(int i=0; i < hash.length; i++){
			hashHexString[i] = Integer.toHexString(hash[i]);
		}
		String inputString = Arrays.toString(hashHexString);

		Pattern pattern1 = Pattern.compile("(?i)(f{1,6})?([\\w]{1,2})");
		Pattern pattern2 = Pattern.compile("(?i)([\\W])([\\w])([\\W])");
		Pattern pattern3 = Pattern.compile("(?i)([\\s,\\[\\]]+)");

		Matcher matcher1 = pattern1.matcher(inputString);
		String replacedString1 = matcher1.replaceAll("$2");
		Matcher matcher2 = pattern2.matcher(replacedString1);
		String replacedString2 = matcher2.replaceAll("$10$2$3");
		Matcher matcher3 = pattern3.matcher(replacedString2);
		String replacedString3 = matcher3.replaceAll("");

		return replacedString3.toUpperCase();
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println("-----------------------");
		System.out.println(hash("password", "SHA-256"));
		System.out.println(hash("passwort", "SHA-256"));
		System.out.println("-----------------------");
	}
}
