package BOJ_1015;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        * 주어진 배열의 각 원소의 값과 인덱스를 Entry로 만들어 리스트에 넣는다.
        * 원소의 값을 기준으로 사용하여 정렬한 후, 정렬된 리스트를 순회한다.
        * 정렬된 리스트를 순회할 때 원소 속에 담긴 인덱스를 결과 배열의 인덱스로 사용하고, 정렬된 리스트속 원소의 인덱스를 값으로 저장한다.
        * 결과 배열을 출력한다.
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        int i = 0;
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            list.add(new AbstractMap.SimpleEntry<>(
                    Integer.parseInt(st.nextToken()), i++));
        }

        list.sort(Comparator.comparingInt(Map.Entry::getKey));
        int[] result = new int[n];
        StringBuilder sb = new StringBuilder();
        i = 0;
        for(Map.Entry<Integer, Integer> iter : list) {
            result[iter.getValue()] = i++;
        }
        for(int j : result) {
            sb.append(j);
            sb.append(" ");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
