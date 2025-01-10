import java.io.*;


public class BOJ_1065 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = 0;
        int n = Integer.parseInt(br.readLine());
        for(int i=1; i<=n; i++) {
            count += hansu(i);
        }
        bw.write(String.format("%d",count));
        br.close();
        bw.close();
    }
    public static int hansu(int n) {
        int c = n;
        int d = n%10;
        n /= 10;
        int step = n%10 - d;
        d = n%10;
        n /= 10;
        while(n > 0) {
            if (n%10 - d != step) {
                return 0;
            }
            d = n%10;
            n /= 10;
        }
        return 1;
    }
}