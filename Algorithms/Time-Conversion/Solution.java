import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        if(s.charAt(s.length()-2) == "A".charAt(0)){
            if(Integer.parseInt(s.substring(0, 2)) == 12)
                return "00" + s.substring(2, s.length() - 2);
            return s.substring(0, s.length() - 2);
        }else{
            s = s.substring(0, s.length() - 2);
            int start = Integer.parseInt(s.substring(0, 2));
            start = start == 12 ? 12 : start+12;
            s = s.substring(2, s.length());
            return Integer.toString(start) + s;
        }
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
