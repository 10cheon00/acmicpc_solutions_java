package BOJ_1389;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    public int from;
    public int dist;

    public Pair(int from, int dist) {
        this.from = from;
        this.dist = dist;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        // dfs로 찾는다면, 찾은 경로가 최소 거리인지 알 수 없으므로 bfs로 찾아야 한다. 가중치가 모두 1이므로 괜찮다
        boolean[][] graph = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            graph[from][to] = true;
            graph[to][from] = true;
        }

        int min = Integer.MAX_VALUE;
        int minI = 0;
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            // bfs로 현재 위치로부터 모든 정점간 최소 거리 갱신
            int[] dist = new int[N + 1];
            boolean[] visited = new boolean[N + 1];
            queue.add(new Pair(i, 0));

            while (!queue.isEmpty()) {
                Pair pair = queue.poll();
                if (visited[pair.from]) {
                    continue;
                }
                visited[pair.from] = true;
                dist[pair.from] = pair.dist;
                for (int to = 1; to <= N; to++) {
                    if (graph[pair.from][to]) {
                        queue.add(new Pair(to, pair.dist + 1));
                    }
                }
            }
            // 모든 정점의 거리가 갱신되었다면 케빈 베이컨 값이 최소인지 확인
            // 모든 위치에 대해서 반복
            int sum = 0;
            for (int j = 1; j <= N; j++) {
                sum += dist[j];
            }
            if (sum < min) {
                min = sum;
                minI = i;
            }
        }

        bw.write(String.valueOf(minI));

        br.close();
        bw.close();
    }
}