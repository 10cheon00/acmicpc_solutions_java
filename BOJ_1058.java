import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        boolean[][] graph = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= str.length(); j++) {
                char c = str.charAt(j - 1);
                graph[i][j] = c == 'Y';
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            Queue<Integer> queue = new LinkedList<>();
            int count = 0;
            int[] dist = new int[n + 1];

            visited[i] = true;
            queue.add(i);
            while (!queue.isEmpty()) {
                int from = queue.poll();
                for (int to = 1; to <= n; to++) {
                    if (graph[from][to] && !visited[to]) {
                        queue.add(to);
                        visited[to] = true;
                        dist[to] = dist[from] + 1;
                        if (dist[to] <= 2) {
                            count++;
                        }
                    }
                }
            }

            max = max < count ? count : max;
        }
        bw.write(String.format("%d", max));

        br.close();
        bw.close();
    }
}