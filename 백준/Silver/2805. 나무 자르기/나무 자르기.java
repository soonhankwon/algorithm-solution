import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = inputs[0];
        int m = inputs[1];
        int[] trees = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int left = 0;
        int right = trees[n - 1];
        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = Arrays.stream(trees)
                    .filter(i -> i > mid)
                    .mapToLong(i -> i - mid)
                    .sum();
            if (sum >= m) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
        br.close();
    }
}
