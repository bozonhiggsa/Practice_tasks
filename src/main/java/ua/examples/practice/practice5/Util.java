package ua.examples.practice.practice5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Util {

    private static final String ENCODING = "UTF-8";
    private static final String FILE = "part54.txt";
    private static final int M = 4;
    private static final int N = 100;

    public static void main(String[] args) {

        String stringWithNumbers = createStringWithNumbers();
        writeToFile(FILE, stringWithNumbers, ENCODING);
    }

    private static void writeToFile(String fileName, String message, String encoding) {

        try(OutputStream os = new FileOutputStream(fileName);
            Writer osw = new OutputStreamWriter(os, encoding)) {
            osw.write(message);
            osw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String createStringWithNumbers() {

        String lineSeparator = System.lineSeparator();

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < (M - 1); i++){
            for (int k = 0; k < (N - 1); k++) {
                builder.append((int) (Math.random() * 1000)).append(" ");
            }
            builder.append((int) (Math.random() * 1000)).append(lineSeparator);
        }
        for (int k = 0; k < (N - 1); k++) {
            builder.append((int) (Math.random() * 1000)).append(" ");
        }
        builder.append((int) (Math.random() * 1000));
        return builder.toString();
    }

    public static int[][] readIntArray() {

        List<String> list = new ArrayList<>();
        try(Scanner scanner1 = new Scanner(new File(FILE), ENCODING)) {
            while (scanner1.hasNextLine()) {
                list.add(scanner1.nextLine());
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int localM = list.size();
        List<Integer> listTemp = new ArrayList<>();
        Scanner scannerTemp = new Scanner(list.get(0));
        while (scannerTemp.hasNext()) {
            if (scannerTemp.hasNextInt()) {
                listTemp.add(scannerTemp.nextInt());
            } else {
                scannerTemp.next();
            }
        }
        scannerTemp.close();
        int localN = listTemp.size();

        int[][] arrayNumbers = new int[localM][localN];
        for(int i = 0; i < localM; i++ ){
            List<Integer> list2 = new ArrayList<>();
            Scanner scanner2 = new Scanner(list.get(i));
                while (scanner2.hasNext()) {
                    if (scanner2.hasNextInt()) {
                        list2.add(scanner2.nextInt());
                    } else {
                        scanner2.next();
                    }
                }
            scanner2.close();

            for(int k = 0; k < localN; k++){
                arrayNumbers[i][k] = list2.get(k);
            }
        }
        return  arrayNumbers;
    }
}
