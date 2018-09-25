import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the checkMagazine function below.
    static String checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> mag = new HashMap<>();
        for(String s : magazine) mag.merge(s, 1, Integer::sum);
        for(String s : note){
            if(!mag.containsKey(s)) return "No";
            else {
                if(mag.get(s) - 1 == 0) mag.remove(s);
                else mag.put(s, mag.get(s)-1);
            }
        }
        return "Yes";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        System.out.println(checkMagazine(magazine, note));

        scanner.close();
    }
}
