package BOJ_1697;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        if (n == k) {
            bw.write("0");
        } else {
            int[] visited = new int[200001];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(n);
            visited[n] = 0;
            while (!queue.isEmpty()) {
                int t = queue.poll();
                if (t == k) {
                    bw.write(String.valueOf(visited[t]));
                    break;
                }
                if (t + 1 < 100001 && visited[t + 1] == 0) {
                    visited[t + 1] = visited[t] + 1;
                    queue.add(t + 1);
                }
                if (t - 1 >= 0 && visited[t - 1] == 0) {
                    visited[t - 1] = visited[t] + 1;
                    queue.add(t - 1);
                }
                if (t * 2 < 200000 && visited[t * 2] == 0) {
                    visited[t * 2] = visited[t] + 1;
                    queue.add(t * 2);
                }
            }
        }
        br.close();
        bw.close();
    }
}
