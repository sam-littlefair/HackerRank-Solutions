import java.io.*;
import java.util.*;

public class Solution {
    public static String append(String S, String W){
        StringBuilder sb = new StringBuilder(S);
        sb.append(W);
        return sb.toString();
    }
    public static String delete(String S, int k){
        return S.substring(0, S.length() - k);
    }
    public static void print(String S, int k){
        System.out.println(S.charAt(k-1));
    }
    public static void main(String[] args) {
        ArrayList<String> history = new ArrayList<String>();
        Scanner sc =  new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        String S = "";
        history.add(S);
        for(int i = 0; i < num; i++){
            String line = sc.nextLine();
            int operation = Integer.parseInt(Character.toString(line.charAt(0)));

            if(operation != 4) line = line.substring(2, line.length());

            if(operation == 1){
                S = append(S, line);
                history.add(S);
            }
            else if(operation == 2){
                S = delete(S, Integer.parseInt(line));
                history.add(S);
            }
            else if(operation == 3) print(S, Integer.parseInt(line));
            else if(operation == 4){
                S = history.get(history.size()-2);
                history.remove(history.size()-1);
            }
        }
    }
}