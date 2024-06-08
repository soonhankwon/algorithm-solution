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
        int a = inputs[0];
        int b = inputs[1];
        int[] arr = new int[b];
        int cnt = 0;
        int index = 1;
        for (int i = 1; i <= b; i++) {
            if (cnt == index) {
                index++;
                cnt = 0;
            }
            arr[i - 1] = index;
            cnt++;
        }
        int[] prefixSum = new int[b];
        for (int i = 0; i < b; i++) {
            if (i == 0) {
                prefixSum[i] = arr[i];
                continue;
            }
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
        if (a < 2) {
            System.out.println(prefixSum[b - 1]);
        } else {
            System.out.println(prefixSum[b - 1] - prefixSum[a - 2]);
        }
        br.close();
    }
}
