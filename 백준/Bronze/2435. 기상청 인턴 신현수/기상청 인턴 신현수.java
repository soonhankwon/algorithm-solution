import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * Input: n(전체 날짜의 수), k(연속적인 날짜의 수)
         * 10 2
         * 3 -2 -4 -9 0 3 7 13 8 -3
         * Output:
         * 21
         * 연속적인 k일의 온도의 합이 최대가 되는 값 출력
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int k = input[1];

        int[] temperatures = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maxSum = Integer.MIN_VALUE;
        int startIndex = 0;
        while(k - 1 < temperatures.length) {
            int sum = 0;
            for(int i = startIndex; i < k; i++) {
                sum += temperatures[i];
            }
            maxSum = Math.max(sum, maxSum);
            k++;
            startIndex++;
        }
        System.out.println(maxSum);
        br.close();
    }
}