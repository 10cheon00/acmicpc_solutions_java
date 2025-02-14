package BOJ_1072;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long X, Y, Z;
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        Z = (Y * 100) / X;

        int left = 0, right = 1000000000;
        while (left <= right) {
            int mid = (left + right) / 2;
            long W = (Y + mid) * 100 / (X + mid);
            if (W == Z) {
                left = mid + 1;
            } else if (W > Z) {
                right = mid - 1;
            }
        }
        if (left > 1000000000) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(left));
        }


        br.close();
        bw.close();
    }
}
