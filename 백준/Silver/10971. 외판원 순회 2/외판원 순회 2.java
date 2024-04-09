import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 외판원 순회(TSP) - 모든 지점을 방문하는 최소비용을 구함
 * 도시간의 비용이 0일 경우 - Self route
 * 출발지점은 정해지지 않음
 */
public class Main {

    static int[][] w;
    static boolean[] visited;
    static int n, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //도시의 수

        // map 만들기
        w = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < n; j++) {
                w[i][j] = inputs[j];
            }
        }

        answer = Integer.MAX_VALUE;
        // 각기 다른 도시 출발지 탐색
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            visited[i] = true;
            // start = now = i -> 출발지가 자신
            recursion(i, i, 0);
        }

        System.out.println(answer);
        br.close();
    }

    private static void recursion(int start, int now, int len) {
        if (isCompleted()) {
            if (w[now][start] != 0) {
                answer = Math.min(answer, len + w[now][0]);
            }
            return;
        }

        // index start + 1 부터 시작
        for (int i = start + 1; i < n; i++) {
            if (!visited[i] && w[now][i] != 0) {
                visited[i] = true;
                recursion(start, i, len + w[now][i]);
                visited[i] = false;
            }
        }
    }

    private static boolean isCompleted() {
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}
