import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int[][] arr;
    static int[] xArr, yArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][2];
        xArr = new int[n];
        yArr = new int[n];

        for (int i = 0; i < n; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int x = inputs[0];
            int y = inputs[1];
            arr[i][0] = y;
            arr[i][1] = x;
            yArr[i] = y;
            xArr[i] = x;
        }

        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int nowY = yArr[i];
                int nowX = xArr[j];

                int[] tempArr = new int[n];
                for (int k = 0; k < n; k++) {
                    int requiredDistance = Math.abs(nowY - arr[k][0]) + Math.abs(nowX - arr[k][1]);
                    tempArr[k] = requiredDistance;
                }

                Arrays.sort(tempArr);
                for (int k = 1; k < n; k++) {
                    tempArr[k] = tempArr[k] + tempArr[k - 1];
                }

                if (i == 0 && j == 0) {
                    if (n >= 0) {
                        System.arraycopy(tempArr, 0, answer, 0, n);
                    }
                }
                for (int k = 0; k < n; k++) {
                    if (answer[k] > tempArr[k]) {
                        answer[k] = tempArr[k];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < n; k++) {
            sb.append(answer[k]).append(" ");
        }

        System.out.println(sb);
        br.close();
    }

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
