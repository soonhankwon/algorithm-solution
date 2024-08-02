import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] row = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        int[] dp = new int[n];
        System.arraycopy(row, 0, dp, 0, n);

        int answer = dp[0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (row[i] > row[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + row[i]);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
        br.close();
    }
}