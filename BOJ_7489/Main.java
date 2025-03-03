package BOJ_7489;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        while(n-->0) {
            int k = Integer.parseInt(br.readLine());
            int res = 1;
            for(int i=1; i<=k;i++){
                res *= i;
                while (res % 10 == 0) {
                    res /= 10;
                }
                res %= 1000;
            }
            bw.write(res % 10 + "\n");
        }

        br.close();
        bw.close();
    }
}
