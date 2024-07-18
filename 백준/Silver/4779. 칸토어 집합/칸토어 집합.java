import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 프랙탈 구조
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null && !s.isEmpty()) {
            int n = Integer.parseInt(s);
            char[] cantorArr = new char[(int) Math.pow(3, n)];
            Arrays.fill(cantorArr, '-');
            executeCantorSet(cantorArr, 0, cantorArr.length, n);
            sb.append(cantorArr).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void executeCantorSet(char[] cantorArr, int start, int length, int depth) {
        if (depth == 0) {
            return;
        }
        int segment = length / 3;
        // 공백 채우기
        for (int i = start + segment; i < start + 2 * segment; i++) {
            cantorArr[i] = ' ';
        }
        // 왼쪽 부분 재귀호출
        executeCantorSet(cantorArr, start, segment, depth - 1);
        // 오른쪽 부분 재귀호출
        executeCantorSet(cantorArr, start + 2 * segment, segment, depth - 1);
    }
}