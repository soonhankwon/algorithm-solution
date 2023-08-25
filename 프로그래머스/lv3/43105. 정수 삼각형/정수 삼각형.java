import java.util.Arrays;

class Solution {
    
    static int[][] dp;
    static int[][] data;
    static int answer;
    static int n;
    
    public int solution(int[][] triangle) {
        n = triangle.length;
        dp = new int[n][n];
        data = triangle;
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        answer = Integer.MIN_VALUE;
        answer = recursion(0, 0);
        return answer;
    }
    
    private static int recursion(int depth, int pointer) {
        if (depth == n) {
            return 0;
        }

        if (dp[depth][pointer] != -1) {
            return dp[depth][pointer];
        }

        dp[depth][pointer] = Math.max(
                recursion(depth + 1, pointer + 1) + data[depth][pointer],
                recursion(depth + 1, pointer) + data[depth][pointer]);

        return dp[depth][pointer];
    }
}