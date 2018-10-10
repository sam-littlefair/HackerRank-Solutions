import java.io.*;
import java.util.*;

public class Solution {
    public static class Node {
        int index;
        int depth;
        LinkedList<Integer> adj;
        boolean visited;
        public Node(int i){
            this.index = i;
            this.adj = new LinkedList<Integer>();
        }
        public void addToList(int i){
            adj.add(i);
        }
    }

    public static void breadthFirstLength(int s, Node[] nodeArr){
        boolean visited[] = new boolean[nodeArr.length+1];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0)
        {
            s = queue.poll();
            Iterator<Integer> i = nodeArr[s].adj.listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n])
                {
                    nodeArr[n].depth = nodeArr[s].depth + 6;
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int queries = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < queries; i++){
            String[] values = sc.nextLine().split(" ");

            int nodes = Integer.parseInt(values[0]);
            int edges = Integer.parseInt(values[1]);
            Node[] nodeArr = new Node[nodes+1];
            for(int k = 1; k <= nodes; k++){
                nodeArr[k] = new Node(k);
            }
            for(int j = 0; j < edges; j++){
                String[] toadd = sc.nextLine().split(" ");
                int node1 = Integer.parseInt(toadd[0]);
                int node2 = Integer.parseInt(toadd[1]);
                nodeArr[node1].addToList(node2);
                nodeArr[node2].addToList(node1);
            }

            int start = sc.nextInt();
            if(sc.hasNext()) sc.nextLine();
            breadthFirstLength(start, nodeArr);

            for(int x = 1; x < nodeArr.length; x++){
                if(x!=start)
                    System.out.print(nodeArr[x].depth == 0 ? -1 + " " : nodeArr[x].depth + " ");
            }
            System.out.println();
        }
    }
}