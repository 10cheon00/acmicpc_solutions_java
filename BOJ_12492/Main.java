package BOJ_12492;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);

            char[][] map = new char[r][c];
            for (int j = 0; j < r; j++) {
                map[j] = br.readLine().toCharArray();
            }

            boolean coverable = cover(map, r, c);
            if (coverable) {
                bw.write("Case #" + i + ":" + print(map, r, c) + '\n');
            } else {
                bw.write("Case #" + i + ":\nImpossible\n");
            }
        }
        bw.close();
        br.close();
    }

    private static String print(char[][] map, int r, int c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            sb.append("\n");
            for (int j = 0; j < c; j++) {
                char ch = map[i][j];
                if (ch == '1') {
                    sb.append("/");
                } else if (ch == '2') {
                    sb.append("\\");
                } else {
                    sb.append(".");
                }
            }
        }
        return sb.toString();
    }

    public static boolean cover(char[][] map, int r, int c) {
        for (int i = 0; i < r - 1; i++) {
            for (int j = 0; j < c - 1; j++) {
                if (map[i][j] == '#' && map[i][j + 1] == '#' && map[i + 1][j] == '#' && map[i + 1][j + 1] == '#') {
                    map[i][j] = '1';
                    map[i][j + 1] = '2';
                    map[i + 1][j] = '2';
                    map[i + 1][j + 1] = '1';
                    j++;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '#') {
                    return false;
                }
            }
        }
        return true;
    }
}
/*
1
4 4
####
####
.##.
.##.
*/