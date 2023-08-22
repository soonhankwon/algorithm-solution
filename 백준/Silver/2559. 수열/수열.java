import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = inputs[0];
        int k = inputs[1];

        int[] records = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] prefixSum = new int[n + 1];
        IntStream.rangeClosed(1, n)
                .forEach(i -> prefixSum[i] = prefixSum[i - 1] + records[i - 1]);

        int maxDegree = Integer.MIN_VALUE;
        for (int i = k; i <= n; i++) {
            int sum = prefixSum[i] - prefixSum[i - k];
            maxDegree = Math.max(maxDegree, sum);
        }
        System.out.println(maxDegree);
    }
}
