package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class P2559_수열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nk = Stream.of(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();
		
		int[] temperature = Stream.of(br.readLine().split(" "))
				.mapToInt(Integer::parseInt).toArray();

		int[] prefixSum = new int[nk[0] + 1];

		// 온도 자료구조와 구간합 자료 만들기
		for (int i = 0; i < nk[0]; i++) {
			if(i == 0) {
				prefixSum[i] = temperature[i];
			} else {
				prefixSum[i] = prefixSum[i - 1] + temperature[i];
			}
		}

		// 연속적인 K일의 온도의 합이 최대가 되는 값 출력
		// 투포인터를 적용해서 K일에 해당하지 않는 구간합을 빼준 sum을 구한다.
		int maxSum = Integer.MIN_VALUE;
		for (int i = nk[1]; i <= nk[0]; i++) {
			int sum = prefixSum[i] - prefixSum[i - nk[1]];
			maxSum = Math.max(maxSum, sum);
		}
		System.out.println(maxSum);
	}
