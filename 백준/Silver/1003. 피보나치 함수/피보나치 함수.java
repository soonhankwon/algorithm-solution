import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[][] dp;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        dp = new int[41][2];

        //dp 배열 초기화
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        // n=0, n=1일 때 호출횟수 업데이트
        dp[0][0] = 1; //n=0, 0 호출횟수
        dp[0][1] = 0; //n=0, 1 호출횟수
        dp[1][0] = 0; //n=1, 0 호출횟수
        dp[1][1] = 1; //n=1, 1 호출횟수

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            answer = 0;
            int input = Integer.parseInt(br.readLine());
            int[] fibonacci = fibonacci(input);
            sb.append(fibonacci[0]).append(" ").append(fibonacci[1]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int[] fibonacci(int n) {
        if (dp[n][0] == -1 || dp[n][1] == -1) {
            // n에 대한 0, 1 호출횟수 재귀호출 진행
            dp[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
            dp[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
        }
        // n에 대한 0, 1 -> [n][0], [n][1]을 리턴해줌
        return dp[n];
    }
}
