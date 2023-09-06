import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /**
         * M = SALTY    A
         * N = SALE    A
         * LCS(M,N)
         * "SALA"
         * if 끝의 문자가 같다면, 하나씩 때서 없애주고, +1을 해준다.
         * else 같지 않다면
         */
        String m = br.readLine();
        String n = br.readLine();

        int mLength = m.length();
        int nLength = n.length();

        int[][] dp = new int[mLength + 1][nLength + 1];
        for(int i = 1; i <= mLength; i++) {
            for(int j = 1; j <= nLength; j++) {
                if(m.charAt(i - 1) == n.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[mLength][nLength]);
    }
}