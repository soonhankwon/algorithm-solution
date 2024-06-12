import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] prefixSum = new int[10];
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            int n = Integer.parseInt(br.readLine());
            if (i == 0) {
                prefixSum[i] = n;
                continue;
            }
            prefixSum[i] = prefixSum[i - 1] + n;
            if (prefixSum[i] >= 100) {
                int abs1 = Math.abs(100 - prefixSum[i - 1]);
                int abs2 = Math.abs(100 - prefixSum[i]);
                if (abs1 == abs2) {
                    answer = prefixSum[i];
                } else if (abs2 > abs1) {
                    answer = prefixSum[i - 1];
                } else {
                    answer = prefixSum[i];
                }
                break;
            } else {
                answer = prefixSum[i];
            }
        }
        System.out.println(answer);
        br.close();
    }
}
