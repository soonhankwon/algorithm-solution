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
        int b = inputs[2];

        int min = 256;
        int max = 0;
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            int[] data = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < m; j++) {
                arr[i][j] = data[j];
                min = Math.min(min, arr[i][j]);
                max = Math.max(max, arr[i][j]);
            }
        }

        int time = 99_999_999;
        int high = 0;
        for (int i = min; i <= max; i++) {
            int cnt = 0;
            int block = b;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    // 현재 좌표의 층이 만들 층보다 높으면 제거, 블록은 제거한 만큼 추가, 시간은 두배로
                    if (i < arr[j][k]) {
                        cnt += ((arr[j][k] - i) * 2);
                        block += (arr[j][k] - i);
                        // 낮을 경우 블록 제거, 시간은 1배
                    } else {
                        cnt += (i - arr[j][k]);
                        block -= (i - arr[j][k]);
                    }
                }
            }
            // 블록의 개수가 음수가 되면 반복문 종료
            if (block < 0) {
                break;
            }

            if (time >= cnt) {
                time = cnt;
                high = i;
            }
        }
        System.out.println(time + " " + high);
        br.close();
    }
}
