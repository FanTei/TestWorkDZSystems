package menu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static String inputString(String text) {
        System.out.println(text);
        try {

            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int inputNumber(String text) {
        System.out.println(text);
        try {
            String value = reader.readLine();
            int num  = tryParseInt(value);
            return num;
        }catch (Exception e){}
       return 0;
    }

    private static int tryParseInt(String value) {
        String exceptionString = "Input the number";
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            inputNumber(exceptionString);
        }
        return -1;
    }
}
