import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/*
 * 마법사 상어와 비바라기
 * 비바라기 마법 시뮬레이션
 */
public class Main {

    static int n, m, answer;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Cloud> queue;
    static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = inputs[0];
        m = inputs[1];

        map = new int[n][n];
        visited = new boolean[n][n]; //구름 방문(위치) 배열
        for (int i = 0; i < n; i++) {
            int[] data = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = data[j];
            }
        }

        queue = new ArrayDeque<>();
        queue.add(new Cloud(n - 1, 0));
        queue.add(new Cloud(n - 1, 1));
        queue.add(new Cloud(n - 2, 0));
        queue.add(new Cloud(n - 2, 1));

        for (int i = 0; i < m; i++) {
            int[] data = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int operation = data[0] - 1;
            int value = data[1];

            // 1. 모든 구름이 di 방향으로 si칸 이동한다.
            // 2. 구름이 있는 칸의 바구니에 저장된 물의양이 1 증가
            operationOneAndTwo(operation, value);
            // 3. 구름이 모두 사라진다.
            // 4. 2에서 물이 증가한 칸(r,c)에 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니 수만큼 물의 양이 증가한다.
            operationThreeAndFour();
            // 5. 바구니에 저장된 물의 양이 2이상인 모든 칸에 구름이 생기고, 물의 양이 2줄어든다.
            // 5.1 이때 구름이 사라진칸은 제외된다.
            operationFive();
        }
        for (int[] arr : map) {
            Arrays.stream(arr).forEach(res -> answer += res);
        }
        System.out.println(answer);
        br.close();
    }

    private static void operationOneAndTwo(int operation, int value) {
        for (Cloud c : queue) {
            // 구름을 di 방향으로 si칸 이동
            c.x = (n + c.x + dx[operation] * (value % n)) % n;
            c.y = (n + c.y + dy[operation] * (value % n)) % n;

            // 구름에서 비를 내림!
            map[c.x][c.y]++;
        }
    }

    private static void operationThreeAndFour() {
        while (!queue.isEmpty()) {
            // 구름을 사라지게 한다.
            Cloud cloud = queue.poll();

            // 구름이 생기는 칸은 3에서 사라진 칸이 아니어야 함 -> 방문배열에 체크
            visited[cloud.x][cloud.y] = true;

            // 물복사
            int cnt = 0;
            // 대각선
            for (int i = 1; i <= 7; i += 2) {
                int x1 = cloud.x + dx[i];
                int y1 = cloud.y + dy[i];

                if (!isMovable(x1, y1)) {
                    continue;
                }

                if (map[x1][y1] > 0) {
                    cnt++;
                }
            }

            // 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니 수만큼 물 증가
            map[cloud.x][cloud.y] += cnt;
        }
    }

    private static void operationFive() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // operation 3에서 사라진 칸이 아님 && 물의 양이 2이상인 칸
                if (!visited[i][j] && map[i][j] >= 2) {
                    queue.add(new Cloud(i, j));
                    map[i][j] -= 2;
                }
            }
        }

        // 구름 방문 배열 초기화
        visited = new boolean[n][n];
    }

    private static boolean isMovable(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    private static class Cloud {
        int x;
        int y;

        public Cloud(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
