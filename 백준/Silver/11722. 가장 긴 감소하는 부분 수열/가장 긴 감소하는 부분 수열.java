import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 가장 긴 감소하는 부분 수열 DP
 */
public class Main {

    static int[] dp, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] inputs = br.readLine().split(" ");
        // dp, arr 인덱스를 맞춰주기 위해 초기화
        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(inputs[i - 1]);
        }

        dp = new int[n + 1];

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            // dp 시작값
            dp[i] = 1;

            for (int j = 1; j < i; j++) {
                // 시작값과 비교
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
        br.close();
    }
}
