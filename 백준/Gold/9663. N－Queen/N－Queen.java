import java.util.Scanner;

public class Main {
	static int[] arr;
	static int cnt;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		dfs(0);
		System.out.println(cnt);
	}

	private static void dfs(int depth) {
		// 퀸을 조건에 맞게 배치한다면 카운트 & 재귀 종료 
		if (depth == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			// 검사할 퀸의 체스판 행 위치   
			arr[depth] = i;
			if (canPut(depth)) {
				// 검사해서 놓을 수 있는 위치 면 다음 퀸으로 이동
				dfs(depth + 1);
			}
		}
	}

	private static boolean canPut(int column) {
		for (int i = 0; i < column; i++) {
			// 1. 퀸의 이동범위 행에 일치하는게 있는가 
			if (arr[column] == arr[i]) {
				return false;
			} 
			// 2. 퀸의 이동범위 대각선에 일치하는게 있는가 
			else if (Math.abs(column - i) == Math.abs(arr[column] - arr[i])) {
				return false;
			}
		}
		return true;
	}
}
