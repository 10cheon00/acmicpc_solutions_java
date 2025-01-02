import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1063 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String kingStart = st.nextToken();
        String rockStart = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        int kx = kingStart.charAt(0) - 'A' + 1;
        int ky = kingStart.charAt(1) - '0';
        int rx = rockStart.charAt(0) - 'A' + 1;
        int ry = rockStart.charAt(1) - '0';

        int mx = 0, my = 0;
        for (int i = 0; i < N; i++) {
            // get input
            String move = br.readLine();
            switch (move) {
                case "R":
                    mx = 1;
                    my = 0;
                    break;
                case "L":
                    mx = -1;
                    my = 0;
                    break;
                case "B":
                    mx = 0;
                    my = -1;
                    break;
                case "T":
                    mx = 0;
                    my = 1;
                    break;
                case "RT":
                    mx = 1;
                    my = 1;
                    break;
                case "LT":
                    mx = -1;
                    my = 1;
                    break;
                case "RB":
                    mx = 1;
                    my = -1;
                    break;
                case "LB":
                    mx = -1;
                    my = -1;
                    break;
            }
            // check boundary
            boolean ok = true;
            boolean collide = false;
            if (kx + mx == rx && ky + my == ry) {
                collide = true;
                ok = boundary(rx + mx, ry + my);
            } else {
                ok = boundary(kx + mx, ky + my);
            }
            // move
            if (ok) {
                kx += mx;
                ky += my;
                if (collide) {
                    rx += mx;
                    ry += my;
                }
            }
        }

        bw.write(translate(kx, ky));
        bw.newLine();
        bw.write(translate(rx, ry));
        br.close();
        bw.close();
    }

    public static boolean boundary(int x, int y) {
        return x <= 8 && x > 0 && y <= 8 && y > 0;
    }

    public static String translate(int x, int y) {
        return String.format("%c%d", x + 'A' - 1, y);
    }
}
