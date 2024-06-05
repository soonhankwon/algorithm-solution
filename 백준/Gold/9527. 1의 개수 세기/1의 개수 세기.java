import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * dp + bitmask
 */
public class Main {

    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        long n = inputs[0];
        long m = inputs[1];
        dp = new long[55];
        dp[0] = 1;
        for (int i = 1; i < 55; i++) {
            dp[i] = (dp[i - 1] << 1) + (1L << i);
        }
        long res = calculate(m) - calculate(n - 1);
        System.out.println(res);
        br.close();
    }

    static long calculate(long n) {
        long cnt = n & 1;
        int size = (int) (Math.log(n) / Math.log(2));
        for (int i = size; i > 0; i--) {
            if ((n & (1L << i)) != 0L) {
                cnt += dp[i - 1] + (n - (1L << i) + 1);
                n -= (1L << i);
            }
        }
        return cnt;
    }
}
