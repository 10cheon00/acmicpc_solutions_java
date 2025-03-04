package BOJ_7113;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        // 3x7 = 21 = 9 + 9 + 1 + 1 + 1
        int count = 0;
        while(n * m > 0) {
            if (n > m) {
                n -= m;
            } else {
                m -= n;
            }
            count++;
        }
        System.out.println(count);
        br.close();
    }
}
