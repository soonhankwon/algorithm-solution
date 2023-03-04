import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	private static int N;
	private static int[][] map;
	private static int[][] dp;
	private static final int INF = 1000000 * 16 + 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		N = Integer.parseInt(br.readLine().trim());
		map = new int[16][16];
		dp = new int[16][1 << 16];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(tsp(0, 1));
	}

	private static int tsp(int c, int v) { 
		if (v == (1 << N) - 1) {
			return map[c][0] == 0 ? INF : map[c][0];
		}
		if (dp[c][v] != 0) { 
			return dp[c][v];
		}
		int min_val = INF;
		for (int i = 0; i < N; i++) {
			if ((v & (1 << i)) == 0 && map[c][i] != 0) {
				min_val = Math.min(min_val, tsp(i, (v | (1 << i))) + map[c][i]);
			}
		}
		dp[c][v] = min_val;
		return dp[c][v];
	}
}