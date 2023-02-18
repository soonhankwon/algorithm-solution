import java.util.Scanner;

public class Main {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		arr = new int[M];
		dfs(N, M, 0, 1);
	}
	
	public static void dfs(int N, int M, int depth, int index) {
		if(depth == M) {
			for(int v : arr) {
				System.out.print(v + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = index; i <= N; i++) {
			arr[depth] = i;
			dfs(N, M, depth + 1, i + 1);
		}
	}
}