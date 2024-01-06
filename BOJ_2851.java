import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            if (Math.abs(100 - sum) >= Math.abs(100 - (sum + arr[i]))) {
                sum = sum + arr[i];
            } else {
                break;
            }
        }

        bw.write(String.format("%d", sum));
        br.close();
        bw.close();
    }
}
