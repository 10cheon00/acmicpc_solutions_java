package BOJ_1835;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        Deque<Integer> deque = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        deque.add(n);
        while(--n > 0) {
            deque.addFirst(n);
            for (int i=0; i<n; i++) {
                deque.addFirst(deque.removeLast());
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Object i : deque.toArray()) {
            sb.append(i);
            sb.append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}
