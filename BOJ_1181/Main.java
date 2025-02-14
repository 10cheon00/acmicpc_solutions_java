package BOJ_1181;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            set.add(str);
        }

        List<String> list = new ArrayList<>(set);

        list.sort((s1, s2) -> {
            int l1 = s1.length();
            int l2 = s2.length();
            if (l1 == l2) {
                return s1.compareTo(s2);
            }
            return l1 - l2;
        });

        for(String s : list) {
            bw.write(s + "\n");

            // 이 방법은 메모리를 많이 잡아먹고, 시간도 더 걸린다.
            // bw.write(String.format("%s\n", s));
        }

        br.close();
        bw.close();
    }
}
