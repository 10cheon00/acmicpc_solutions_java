/*
최초로 생각한 방법은 회의 시간이 가장 짧은 것부터 채워 넣으면 되지 않을까였다.
간단한 반례로는 0 100, 100 200, 99 101이 되겠다.
전체 일정으로 보았을 때 회의 시간이 가장 짧더라도 두 개의 회의 중간에 걸쳐 있다면 그 두 개의 회의를 못하게 되는 셈

반대로 시작 시간 순으로 보았을 때, 0 100, 99 101, 100 200이 된다. 0 100을 고르고 100 200을 고르면 된다.
그렇지만 0 3, 0 4, 0 5, 1 2, 2 3, 3 5 이렇게 주어진다면 0 3을 먼저 고르고 난 다음에 생각하므로, 1 2와 2 3은 고르지 못한다.

즉, 시작 시간이 빨랐지만 실제로는 그것보다 더 빨리 끝나는 회의가 존재할 수 있다는 것. 그 회의를 대신 선택한다면 그 회의가 끝난 직후부터 다른 회의가 들어갈 수 있는 여유가 생긴다.

어떤 범위 내에서 가장 많은 개수의 선분 또는 점을 겹치지 않게 (점은 예외로 쳐 주십쇼) 넣어야 하는 문제로 치환해보자.
귀납적으로 생각할 때 이 문제는 다음과 같다.
정답 중에 제일 앞에 있는 선분이나 점을 안다고 치자. 그 선분의 끝 점부터 주어진 범위의 끝까지를 하위 문제의 범위로 설정하고 똑같은 문제를 푸는 셈이다.

그렇다면 정렬만 잘하면 된다. 어떤 선분을 선택했을 때 그 선분의 끝점부터 주어진 범위의 끝까지의 길이가 가장 크도록 만드는 방법은?
일단 0과 가까워야 하나? 그렇겠다. 그렇지만 선분이 0과 가장 가깝다 하더라도 그 선분이 주어진 범위 내에서 최소한의 범위만 차지하지는 않는다.
하위 문제로 쪼개는 조건은 일단 어떤 선분을 선택했을 때 선택한 선분의 끝점을 제외했을 때 최대한 큰 범위가 되어야 한다.

즉, 끝점의 값을 오름차순으로 정렬하면 된다. 하지만 이렇게만 할 경우 85%에서 실패한다.
여기선 점 때문에 실패하는데, 선분과 접하는 점을 먼저 고를 경우 선분을 고를 수 없기 때문이다. 그래서 시작 시간이 더 빠른 것부터 골라야 한다.
ex)
  --
   -
   ---
 */

package BOJ_1931;

import java.io.*;
import java.util.*;

class Node {
    public int s;
    public int e;

    public Node(int s, int e) {
        this.s = s;
        this.e = e;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] startEnd = br.readLine().split(" ");
            int s = Integer.parseInt(startEnd[0]);
            int e = Integer.parseInt(startEnd[1]);
            list.add(new Node(s, e));
        }
        Collections.sort(list, (n1, n2) -> {
            if (n1.e < n2.e)
                return -1;
            if (n1.e == n2.e && n1.s < n2.s)
                return -1;
            if (n1.e == n2.e && n1.s == n2.s)
                return 0;

            return 1;
        });

        int count = 1;
        long s = list.get(0).s, e = list.get(0).e;
        for (int i = 1; i < list.size(); i++) {
            Node n = list.get(i);
            if ((s - (long)n.e) * (e - (long)n.s) >= 0) {
                e = n.e;
                count++;
            }

        }
        bw.write(String.valueOf(count));
        bw.close();
        br.close();

    }
}
