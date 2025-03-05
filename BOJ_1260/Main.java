package BOJ_1260;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int V = Integer.parseInt(input[2]);

        List[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            String[] foo = br.readLine().split(" ");
            int from = Integer.parseInt(foo[0]);
            int to = Integer.parseInt(foo[1]);
            graph[from].add(to);
            graph[to].add(from);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i], Collections.reverseOrder());
        }

        bw.write(dfs(graph, N + 1, V) + '\n');

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        bw.write(bfs(graph, N + 1, V));

        bw.close();
        br.close();
    }

    private static String dfs(List[] graph, int n, int v) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[n];
        List<Integer> result = new ArrayList<>();

        stack.push(v);
        while (!stack.isEmpty()) {
            int from = stack.pop();
            if (visited[from]) {
                continue;
            }
            result.add(from);
            visited[from] = true;

            graph[from].stream().mapToInt(value -> (int)value).forEach(i -> {
                if (!visited[i]) {
                    stack.push(i);
                }
            });
        }

        StringBuilder sb = new StringBuilder();
        result.forEach(i -> sb.append(i + " "));
        return sb.toString();
    }

    private static String bfs(List[] graph, int n, int v) {
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        queue.add(v);
        while (!queue.isEmpty()) {
            int from = queue.poll();
            if (visited[from]) {
                continue;
            }
            result.add(from);
            visited[from] = true;

            graph[from].stream().mapToInt(value -> (int)value).forEach(i -> {
                if (!visited[i]) {
                    queue.add(i);
                }
            });
        }

        StringBuilder sb = new StringBuilder();
        result.forEach(i -> sb.append(i + " "));
        return sb.toString();
    }

}
