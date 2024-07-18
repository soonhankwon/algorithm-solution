import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[1001];
        // 자기 자신은 팰린드롬 수열
        Arrays.fill(dp, 1);
        for (int i = 1; i <= 1000; i++) {
            for (int j = 0; j < i; j++) {
                // 홀수는 팰린드롬을 만들 수 없음
                if ((i - j) % 2 == 1) {
                    continue;
                }
                dp[i] += dp[(i - j) / 2];
            }
        }
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}
