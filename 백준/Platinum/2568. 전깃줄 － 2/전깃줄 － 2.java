import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
 * A 전봇대 값 기준으로 오름차순 정렬
 * B 전봇대 값으로 LIS 거리 배열
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][2];
        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            map[i][0] = row[0];
            map[i][1] = row[1];
        }
        Arrays.sort(map, Comparator.comparingInt(i -> i[0]));
        int[] arr = Arrays.stream(map)
                .mapToInt(i -> i[1])
                .toArray();
        int[] d = new int[n];
        int[] res = new int[n];
        d[0] = arr[0];
        int size = 1;
        for (int i = 1; i < n; i++) {
            int point = Arrays.binarySearch(d, 0, size, arr[i]);
            point = point >= 0 ? point : Math.abs(point) - 1;
            d[point] = arr[i];
            res[i] = point;
            if (point == size) {
                size++;
            }
        }

        int s = size - 1;
        int i = n - 1;
        boolean[] visited = new boolean[n];
        while (s >= 0) {
            if (res[i] == s) {
                visited[i] = true;
                s--;
            }
            i--;
        }

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            if (!visited[j]) {
                cnt++;
                sb.append(map[j][0]).append("\n");
            }
        }
        System.out.println(cnt);
        if (cnt > 0) {
            sb.setLength(sb.length() - 1);
            System.out.println(sb);
        }
    }
}
