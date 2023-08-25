import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static List<int[]> interviews;
    static int answer;
    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        interviews = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            interviews.add(Arrays.stream(br.readLine()
                            .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray());
        }
        dp = new int[n + 1]; // DP 테이블
        Arrays.fill(dp, 0);

        answer = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (i + interviews.get(i)[0] > n) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(
                        dp[(i + interviews.get(i)[0])] + interviews.get(i)[1],
                        dp[(i + 1)]);
            }
            answer = Math.max(dp[i], answer);
        }

        System.out.println(answer);
    }
}