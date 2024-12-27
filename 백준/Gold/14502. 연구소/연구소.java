import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static int n, m;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = arr[0];
        m = arr[1];
        map = new int[n][m];
        List<Point> virusPoints = new ArrayList<>();

        for(int i = 0; i < arr[0]; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for(int j = 0; j < arr[1]; j++) {
                int num = row[j];
                if(num == 2) {
                    virusPoints.add(new Point(i, j));
                }
                map[i][j] = num;
            }
        }
        dfs(0, virusPoints);
        System.out.println(answer);
        br.close();
    }

    private static void dfs(int wallCnt, List<Point> virusPoints) {
        if(wallCnt == 3) {
            answer = Math.max(answer, bfs(virusPoints));
            return;
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wallCnt + 1, virusPoints);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static int bfs(List<Point> virusPoints) {
        int[][] tempMap = new int[n][m];
        for(int i = 0; i < n; i++) {
            tempMap[i] = map[i].clone();
        }

        Queue<Point> tempQueue = new ArrayDeque<>(virusPoints);
        while(!tempQueue.isEmpty()) {
            Point now = tempQueue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(isMovable(nx, ny) && tempMap[nx][ny] == 0) {
                    tempMap[nx][ny] = 2;
                    tempQueue.add(new Point(nx, ny));
                }
            }
        }

        int safeSpace = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(tempMap[i][j] == 0) {
                    safeSpace++;
                }
            }
        }
        return safeSpace;
    }

    private static boolean isMovable(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
