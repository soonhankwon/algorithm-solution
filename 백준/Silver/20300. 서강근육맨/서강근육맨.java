import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    /*
     * 해결법: Greedy, Two Pointers
     * 1. 오름차순 정렬
     * 2. 홀수면 가장 끝은 따로 계산하고 양 끝 포인터를 가운데로 이동시키면서 연산한다.
     * 3. 짝수면 양 끝 포인터를 가운데로 이동시키면서 연산한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] weights = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .sorted()
                .toArray();

        long maxLoss = 0;
        if(n % 2 != 0) {
            maxLoss = weights[n - 1];
            n--;
        }

        for(int i = 0; i < n / 2; i++) {
            long curSum = weights[i] + weights[n - 1 - i];
            maxLoss = Math.max(maxLoss, curSum);
        }
        System.out.println(maxLoss);
        br.close();
    }
}