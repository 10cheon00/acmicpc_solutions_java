package BOJ_22244;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 3; i++) {
            String input = br.readLine();
            int correctness = 1;
            // 유효한 날짜인지 검사
            //   2월 29일일때 윤년인지 검사
            //   월 수가 1~12범위 안에 있는지 검사
            //   일 수가 월별 날짜 범위 안에 있는지 검사
            //
            //
            // 8번째 자리가 1,6,9인지 검사
            // 검증비트 검사
            int day = Integer.parseInt(input.substring(0, 2));
            int month = Integer.parseInt(input.substring(2, 4));
            int year = Integer.parseInt(input.substring(4, 7));
            int author = Integer.parseInt(input.substring(7, 8));
            int parity = Integer.parseInt(input.substring(8, 9));
            year += year < 600 ? 2000 : 1000;

            if (month <= 0 || month > 12) {
                correctness = 0;
            } else if (day <= 0 || day > getDaysOfMonth(month, year)) {
                correctness = 0;
            } else if (author != 1 && author != 6 && author != 9) {
                correctness = 0;
            } else if (parity != Arrays.stream(input.substring(0, 8).split(""))
                .mapToInt(s -> Integer.parseInt(s) * Integer.parseInt(s))
                .sum() % 7) {
                correctness = 0;
            }
            bw.write("" + correctness + '\n');
        }

        bw.close();
        br.close();
    }

    private static int getDaysOfMonth(int month, int year) {
        int[] days = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))) {
            return 29;
        }
        return days[month];
    }
}
