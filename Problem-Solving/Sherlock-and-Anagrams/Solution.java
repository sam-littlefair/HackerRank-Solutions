import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int count = 0;
        HashMap<String, Integer> check = new HashMap<>();
        for(int size = 1; size < s.length(); size++){
            for(int i = 0; i < s.length() - size + 1; i++){
                String toCheck = s.substring(i, i+size);
                char tempArray[] = toCheck.toCharArray();
                Arrays.sort(tempArray);
                toCheck = new String(tempArray);
                check.merge(toCheck, 1, Integer::sum);
            }
        }
        for (Map.Entry<String, Integer> entry : check.entrySet()) {
            if(entry.getValue() > 1){
                count += (entry.getValue() * (entry.getValue()-1)) / 2;
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
