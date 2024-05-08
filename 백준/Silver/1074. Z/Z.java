import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = inputs[0];
        int r = inputs[1];
        int c = inputs[2];
        int size = (int) Math.pow(2, n);

        partition(r, c, size);
        System.out.println(answer);
        br.close();
    }

    private static void partition(int row, int col, int size) {
        if (size == 1) {
            return;
        }

        // 1사분면
        int dividedSize = size / 2;
        if (row < dividedSize && col < dividedSize) {
            partition(row, col, dividedSize);
            return;
        }
        // 2사분면
        if (row < dividedSize) {
            answer += size * size / 4;
            partition(row, col - dividedSize, dividedSize);
            return;
        }
        // 3사분면
        if (col < dividedSize) {
            answer += (size * size / 4) * 2;
            partition(row - dividedSize, col, dividedSize);
            return;
        }
        // 4사분면
        answer += (size * size / 4) * 3;
        partition(row - dividedSize, col - dividedSize, dividedSize);
    }
}
