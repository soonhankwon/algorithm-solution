import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * DP - 특정 계단 위치에서 얻을 수 있는 최대값
 */
public class Main {

    static int[] dp, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = arr[i];
                continue;
            }
            if (i == 2) {
                dp[i] = dp[i - 1] + arr[i];
                continue;
            }
            // 최대값(세 칸 전 메모이제이션 값 + 첫칸 전 값, 두 칸 전 메모이제이션 값 + 첫칸 전 값)
            dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
        }

        System.out.println(dp[n]);
        br.close();
    }
}
