import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int h = Integer.parseInt(inputs[0]); //행 4
        int w = Integer.parseInt(inputs[1]); //열 4
        int r = Integer.parseInt(inputs[2]); //회전수

        int[][] arr = new int[h][w];
        for (int i = 0; i < h; i++) {
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < w; j++) {
                arr[i][j] = Integer.parseInt(data[j]);
            }
        }

        // 작은 부분의 나누기 2가 돌아갈 라인의 수
        int rotationCnt = Math.min(h, w) / 2;
        // 시뮬레이션 구현
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < rotationCnt; j++) {
                // 저장 배열
                int temp = arr[j][j];
                for (int k = j + 1; k < w - j; k++) {
                    arr[j][k - 1] = arr[j][k];
                }
                for (int k = j + 1; k < h - j; k++) {
                    arr[k - 1][w - 1 - j] = arr[k][w - 1 - j];
                }
                for (int k = w - 2 - j; k >= j; k--) {
                    arr[h - 1 - j][k + 1] = arr[h - 1 - j][k];
                }
                for (int k = h - 2 - j; k >= j; k--) {
                    arr[k + 1][j] = arr[k][j];
                }
                arr[j + 1][j] = temp;
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        br.close();
    }
}
