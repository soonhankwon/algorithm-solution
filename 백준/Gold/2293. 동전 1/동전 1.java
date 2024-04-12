import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 동전 1 -> DP 최적화
 */
public class Main {

    static int[] dp, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = inputs[0];
        int k = inputs[1];

        arr = new int[n + 1];
        dp = new int[k + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            int now = arr[i];
            for (int j = now; j <= k; j++) {
                dp[j] += dp[j - now];
            }
        }
        System.out.println(dp[k]);
        br.close();
    }
}
