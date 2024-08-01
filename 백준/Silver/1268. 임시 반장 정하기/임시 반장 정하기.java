import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][5];
        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[] cnt = new int[n];
        int max = 0, result = 1;

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < n; k++) {
                    if (i != k && arr[i][j] == arr[k][j] && !visited[k]) {
                        cnt[i]++;
                        visited[k] = true;
                    }
                }
            }
            if (cnt[i] > max) {
                max = cnt[i];
                result = i + 1;
            }
        }
        System.out.println(result);
        br.close();
    }
}
