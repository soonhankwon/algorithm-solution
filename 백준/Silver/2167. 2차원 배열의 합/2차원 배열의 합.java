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
        int[][] prefixSum = new int[n + 1][m + 1];
        // 배열값 + 왼쪽 누적합 + 위쪽 누적합 - 교집합 누적합
        for (int i = 1; i <= n; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 1; j <= m; j++) {
                prefixSum[i][j] =
                        prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1] + row[j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int i0 = row[0], j0 = row[1], x0 = row[2], y0 = row[3];
            // 전체 누적합 - 왼쪽 누적합 - 위쪽 누적합 + 교집합 누적합
            sb.append(prefixSum[x0][y0] - prefixSum[i0 - 1][y0] - prefixSum[x0][j0 - 1] + prefixSum[i0 - 1][j0 - 1])
                    .append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
