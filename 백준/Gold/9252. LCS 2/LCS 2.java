import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int sLength1 = str1.length();
        int sLength2 = str2.length();

        dp = new int[sLength1 + 1][sLength2 + 1];
        for (int i = 1; i <= sLength1; i++) {
            for (int j = 1; j <= sLength2; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    continue;
                }
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        System.out.println(dp[sLength1][sLength2]);

        StringBuilder sb = new StringBuilder();
        int row = sLength1;
        int col = sLength2;
        while (row > 0 && col > 0) {
            if (dp[row][col] == dp[row - 1][col]) {
                row--;
                continue;
            }
            if (dp[row][col] == dp[row][col - 1]) {
                col--;
                continue;
            }
            sb.append(str1.charAt(row - 1));
            row--;
            col--;
        }
        sb.reverse();
        System.out.println(sb);
        br.close();
    }
}
