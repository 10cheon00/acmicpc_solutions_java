package BOJ_1620;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Map<String, Integer> dict = new HashMap<>();
        String[] names = new String[100001];

        for (int i = 1; i <= N; i++) {
            names[i] = br.readLine();
            dict.put(names[i], i);
        }

        StringBuilder sb = new StringBuilder();
        String name;
        for (int i = 0; i < M; i++) {
            name = br.readLine();
            if (dict.containsKey(name)) {
                sb.append(dict.get(name));
            } else {
                sb.append(names[Integer.parseInt(name)]);
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
