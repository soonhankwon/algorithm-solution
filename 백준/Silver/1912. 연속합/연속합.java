import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        int[] prefixSum = new int[n + 1];
        Arrays.fill(prefixSum, -1000);

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = Math.max(prefixSum[i] + inputs.get(i), inputs.get(i));
        }

        int max = Arrays.stream(prefixSum).max().orElseThrow();
        System.out.println(max);
    }
}