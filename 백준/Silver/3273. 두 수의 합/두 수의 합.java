import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 오름차 순으로 정렬 
		Arrays.sort(arr);
		int cnt = 0;
		int x = sc.nextInt();
		// two pointer 알고리즘 사용 
		int left = 0, right = n - 1;
		while(left < right) {
			int sum = arr[left] + arr[right];
			if(sum < x) {
				left++;
			} else if (sum > x) {
				right--;
			} else {
				cnt++;
				left++;
				right--;
			}
		}
		System.out.println(cnt);
	}
}