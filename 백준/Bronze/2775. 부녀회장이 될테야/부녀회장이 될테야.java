import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int floor = Integer.parseInt(br.readLine()); // 층
            int n = Integer.parseInt(br.readLine()); // 호수 3
            int[] floorInfo = IntStream.rangeClosed(1, n).toArray();
            for (int j = 0; j < floor; j++) {
                int[] dp = new int[n];
                for (int k = 0; k < n; k++) {
                    if (k == 0) {
                        dp[k] = floorInfo[k];
                        continue;
                    }
                    dp[k] = dp[k - 1] + floorInfo[k];
                    if (k == n - 1) {
                        floorInfo = dp;
                    }
                }
            }
            sb.append(floorInfo[n - 1]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
