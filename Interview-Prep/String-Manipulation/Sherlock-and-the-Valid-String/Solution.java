import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        HashMap<Character, Integer> chars = new HashMap<>();

        for(char c : s.toCharArray()) chars.merge(c, 1, Integer::sum);

        int max = chars.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
        int min = chars.entrySet().stream().min(Map.Entry.comparingByValue()).get().getValue();

        long numMin = chars.values().stream().filter(x -> x==min).count();
        long numMax = chars.values().stream().filter(x -> x==max).count();

        long unique = chars.values().stream().distinct().count();

        if(unique > 2) return "NO";
        if(unique == 1) return "YES";

        if(numMin > numMax){
            if(numMax > 1)  return "NO";
        }else{
            if(numMin > 1)  return "NO";
            if(numMin == 1 && min == 1) return "YES";
        }

        if(Math.abs(max-min) > 1) return "NO";

        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
