import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * 전기줄 - DP
 * 증가 또는 감소 수열 방법과 유사함
 * B 전봇대가 이어지는 전선이 감소수열 또는 증가수열이어야 함
 */
public class Main {

    static int[] dp;
    static List<Pair> pairs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        pairs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            pairs.add(new Pair(inputs[0], inputs[1]));
        }

        pairs.sort(Comparator.comparingInt((i) -> i.x));

        dp = new int[n + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (pairs.get(i - 1).y > pairs.get(j - 1).y) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        // 전체 - 설치 가능 전기줄
        System.out.println(n - max);
        br.close();
    }

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
