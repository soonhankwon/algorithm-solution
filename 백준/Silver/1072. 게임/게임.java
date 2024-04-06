import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.BiFunction;

/*
 * 백준 - 1072 게임
 * 게임횟수: X, 이긴게임: Y, 승률: Z
 * 앞으로의 게임은 무조건 이긴다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int x = inputs[0];
        int y = inputs[1];
        // x == y 면 승률이 절대 바뀌지 않음
        if (x == y) {
            System.out.println(-1);
            return;
        }

        // (y / x) * 100 = z
        BiFunction<Integer, Integer, Integer> rateFunction =
                (y1, x1) -> (int) ((long) y1 * 100 / x1);
        int z = rateFunction.apply(y, x);

        int left = 0;
        int right = (int) 1e9;
        int answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            // z랑 다르다면 승률이 변한것이기 때문에 기록하고 범위를 줄여주고 다시 이진탐색을 시작한다.
            if (rateFunction.apply(y + mid, x + mid) != z) {
                answer = mid;
                right = mid - 1;
                continue;
            }
            left = mid + 1;
        }
        System.out.println(answer);
        br.close();
    }
}
