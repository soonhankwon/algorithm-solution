import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 가우스 소거법 -> 기약 행사다리꼴(가우스 조르단 소거법)
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[][] map = new double[n][n + 1];

        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < n + 1; j++) {
                map[i][j] = row[j];
            }
        }

        for (int i = 0; i < n; i++) {
            double div = map[i][i];
            // 가우스 소거법은 곱연산(벡터행의 모든 원소들에 상수 K를 곱한다.) -> 주 대각선 원소로 나누기(가우스-조르단)
            for (int j = i; j <= n; j++) {
                map[i][j] /= div;
            }

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                // 다른 벡터행의 i번째 원소를 0으로 만들기 위해 뺌
                double factor = -map[j][i];
                for (int k = 0; k <= n; k++) {
                    map[j][k] += map[i][k] * factor;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(String.format("%.0f ", map[i][n]));
        }
        System.out.println(sb.toString().trim());
        br.close();
    }
}
