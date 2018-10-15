import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class MyQueue<Integer>{
    private Stack<Integer> start = new Stack<Integer>();
    private Stack<Integer> end = new Stack<Integer>();

    public void shift(){
        while(!end.isEmpty()){
            start.push(end.pop());
        }
    }
    public void enqueue(Integer i){
        end.push(i);
    }

    public Integer dequeue(){
        if(start.isEmpty()) shift();
        return start.pop();
    }

    public Integer peek(){
        if(start.isEmpty()) shift();
        return start.peek();
    }
}

public class Solution {

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}