import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * DP - n가지 동전으로 금액 m을 만드는 모든 방법의 수
 */
public class Main {

    static int[] arr;
    static int[][] dp;
    static int n, target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            target = Integer.parseInt(br.readLine()); // 1000
            dp = new int[n][target + 1];

            int cnt = recursion(0, 0);
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int recursion(int depth, int sum) {
        if (sum == target) {
            return 1;
        }

        if (sum > target || depth >= n) {
            return 0;
        }

        // 이미 계산한 값이 있다면 그 값을 사용함!
        if (dp[depth][sum] != 0) {
            return dp[depth][sum];
        }

        // 현재 동전을 사용하는 경우와 사용하지 않는 경우를 모두 고려하여 경우의 수 계산
        return dp[depth][sum] = recursion(depth, sum + arr[depth])
                + recursion(depth + 1, sum);
    }
}
