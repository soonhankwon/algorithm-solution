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
        int s = inputs[1];
        int[] row = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] arr = new int[n + 1];
        System.arraycopy(row, 0, arr, 0, row.length);

        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (start <= n && end <= n) {
            if (sum >= s && min > end - start) {
                min = end - start;
            }
            sum += sum < s ? arr[end++] : -arr[start++];
        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
        br.close();
    }
}
