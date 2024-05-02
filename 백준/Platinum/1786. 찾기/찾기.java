import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
 * KMP
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String pattern = br.readLine();

        int pLength = pattern.length();
        int[] patternArr = new int[pLength];

        // 전처리
        int index = 0;
        for (int i = 1; i < pLength; i++) {
            while (index > 0 && pattern.charAt(i) != pattern.charAt(index)) {
                index = patternArr[index - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(index)) {
                index++;
                patternArr[i] = index;
            }
        }

        // KMP 알고리즘
        List<Integer> answer = new ArrayList<>();
        int length = str.length();
        int idx = 0;
        for (int i = 0; i < length; i++) {
            while (idx > 0 && str.charAt(i) != pattern.charAt(idx)) {
                idx = patternArr[idx - 1];
            }
            if (str.charAt(i) == pattern.charAt(idx)) {
                if (idx == pLength - 1) {
                    answer.add(i - idx + 1);
                    idx = patternArr[idx];
                } else {
                    idx++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        for (Integer e : answer) {
            sb.append(e).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
