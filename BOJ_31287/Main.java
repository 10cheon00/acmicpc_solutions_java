package BOJ_31287;

import java.io.*;

class Coord {
    public int x, y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        String S = br.readLine();
        boolean isBackToOrigin = step(S, n, k - 1);
        if (isBackToOrigin) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        br.close();
        bw.close();
    }

    private static boolean step(String s, int n, int k) {
        Coord[] coord = new Coord[n];
        int x = 0, y = 0;
        char[] str = s.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = str[i];
            if (c == 'U') {
                y++;
            } else if (c == 'D') {
                y--;
            } else if (c == 'R') {
                x++;
            } else {
                x--;
            }
            coord[i] = new Coord(x, y);
        }
        if (x == y && y == 0) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            int cx = coord[i].x, cy = coord[i].y;
            if (cx == 0 && cy == 0) {
                return true;
            }
            // 좌표가 이동벡터와 방향이 다르고 평행한지
            if (cx * y - cy * x == 0 && cx * x + cy * y < 0) {
                // 해당 좌표에서 k번 이동할 때 정확히 원점을 지나는지 검증...
                if (x != 0 && y != 0) {
                    if (validate(cx, x, k) && validate(cy, y, k)) {
                        return true;
                    }
                } else if (x != 0) {
                    if (validate(cx, x, k)) {
                        return true;
                    }
                } else {
                    if (validate(cy, y, k)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean validate(int cx, int x, int k) {
        return cx % x == 0 && Math.abs(cx / x) <= k;
    }
}
/*
22 2
LLLLLUUUURRRRRRRDDDDDD
22 3
LLLLLUUUURRRRRRRDDDDDD
                 |
                 |
                 |
                 |
                 |
            *~******
            *    | *
            * @~@@@@@@
            * @  | * @
------------**@*#~######---------
              @ #| * @ #
              @@#@@* @ #
                #|   @ #
                #####@ #
                 |     #
                 |     #
                 |

이동거리 = (2, -2)
첫 이동한 좌표중에 원점으로 돌아올 수 있는 좌표 = (-4, 4)
내적을 이용해 평행인지 확인
반복 횟수가 k보다 작을 때 돌아올 수 있는지 확인해야함.
현재 좌표가 이동거리로 나누어 떨어지고, 그 몫이 k보다 작은지 확인?
정확히 0을 지날지 안 지날지 검증해야함.

이동거리 = (2, 0)
그러한 좌표? = (-3, 0)
12 5
DLLLUURRRRRD
11 5
DLLLUURRRRD

          |
          |
          |
       **@@######
-------*-@+#*-@-#---
       **@@####
          |
          |
          |
 */