package BOJ_5430;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String cmd = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine().replace("[", ""). replace("]", "");
            String[] list = input.split(",");
            int f = -1, r = input.isEmpty() ? 0 : list.length, o = 0;
            // f*****r
            for(char s : cmd.toCharArray()) {
                if (s == 'R') {
                    o = 1 - o;
                } else {
                    if (o == 0) {
                        f++;
                    } else {
                        r--;
                    }
                }
            }

            if (f >= r) {
                bw.write("error\n");
            } else if (f + 1 == r) {
                bw.write("[]\n");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                if (o == 0) {
                    while(f + 2 < r) {
                        sb.append(list[++f]).append(",");
                    }
                    sb.append(list[++f]);
                } else {
                    while(f + 2 < r) {
                        sb.append(list[--r]).append(",");
                    }
                    sb.append(list[--r]);
                }
                sb.append("]\n");
                bw.write(sb.toString());
            }
        }

        bw.close();
        br.close();
    }
}
