package ua.examples.practice.practice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part5 {

    private static final String ENCODING = "Cp1251";

    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("^([\\w]+)\\s([\\w]+)$");
        String query = "";
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, ENCODING))) {
            while(!(query = reader.readLine()).equals("stop")){
                Matcher matcher = pattern.matcher(query);
                if(matcher.matches()){
                    String key = matcher.group(1);
                    Locale locale = new Locale(matcher.group(2));
                    System.out.println(retrieveValue(locale, key));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String retrieveValue(Locale locale, String key){

        ResourceBundle rb =
                ResourceBundle.getBundle("resources", locale);

        return rb.getString(key);
    }
}
