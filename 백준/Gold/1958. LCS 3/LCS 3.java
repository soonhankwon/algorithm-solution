import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        int sLength1 = str1.length();
        int sLength2 = str2.length();
        int sLength3 = str3.length();

        int[][][] dp = new int[sLength1 + 1][sLength2 + 1][sLength3 + 1];
        for (int i = 1; i <= sLength1; i++) {
            for (int j = 1; j <= sLength2; j++) {
                for (int k = 1; k <= sLength3; k++) {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1) &&
                            str2.charAt(j - 1) == str3.charAt(k - 1) &&
                            str3.charAt(k - 1) == str1.charAt(i - 1)) {
                        dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
                        continue;
                    }
                    int tempMax = Math.max(dp[i][j - 1][k], dp[i - 1][j][k]);
                    dp[i][j][k] = Math.max(tempMax, dp[i][j][k - 1]);
                }
            }
        }
        System.out.println(dp[sLength1][sLength2][sLength3]);
        br.close();
    }
}
