import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(i + 1);
        }

        int count = 0, outIdx = 0;
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            int numIdx = list.indexOf(num);
            int size = list.size();
            if (size == 1) { // zero division
                break;
            }

            int left = (numIdx - outIdx + size) % size;
            int right = (outIdx - numIdx + size) % size;
            count += Math.min(left, right);
            list.remove(numIdx);
            outIdx = numIdx % list.size();
        }

        bw.write(String.format("%d", count));

        br.close();
        bw.close();
    }
}
