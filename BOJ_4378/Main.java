package BOJ_4378;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Character, Character> keyMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] keys =   "1234567890-=WERTYUIOP[]SDFGHJKL;'XCVBNM,./\\".toCharArray();
        char[] values = "`1234567890-QWERTYUIOP[ASDFGHJKL;ZXCVBNM,.]".toCharArray();
        for(int i = 0; i< keys.length; i++){
            keyMap.put(keys[i], values[i]);
        }
        while (true) {
            String str = br.readLine();
            if (str == null || str.isEmpty()) {
                break;
            }
            StringBuilder sb = new StringBuilder();
            str.chars().forEach(s -> sb.append(fixKey(s)));
            System.out.println(sb);
        }

        br.close();
    }

    private static char fixKey(int i) {
        if (keyMap.containsKey((char)i)) {
            return keyMap.get((char)i);
        }
        return (char)i;
    }
}
