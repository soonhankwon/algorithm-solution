import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 플로이드-워셜
 */
public class Main {

    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < n; j++) {
                dist[i][j] = row[j];
            }
        }

        // 경유 노드 k
        for (int k = 0; k < n; k++) {
            // 출발 노드 i
            for (int i = 0; i < n; i++) {
                // 도착노드 j
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] == 1 && dist[k][j] == 1) {
                        dist[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] arr : dist) {
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
