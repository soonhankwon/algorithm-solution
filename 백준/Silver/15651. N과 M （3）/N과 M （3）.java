import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	static int[] arr;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 1부터 N까지 자연수
		int M = sc.nextInt(); // 수열의 길이 M

		arr = new int[M];
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		dfs(N, M, 0);
		bw.flush();
	}

	public static void dfs(int N, int M, int depth) throws IOException {
		if (depth == M) {
			for (int v : arr) {
				bw.write(v + " ");
			}
			bw.write("\n");
			return;
		}
		for (int i = 1; i <= N; i++) {
			arr[depth] = i;
			dfs(N, M, depth + 1);
		}
	}
}
