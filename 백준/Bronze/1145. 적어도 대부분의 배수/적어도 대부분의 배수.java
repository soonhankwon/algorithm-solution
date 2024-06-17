import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static boolean isEnd = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int num = inputs[0];
        while (!isEnd) {
            int cnt = 0;
            for (int n : inputs) {
                if (isMultiple(num, n)) {
                    cnt++;
                }
                if (cnt == 3) {
                    isEnd = true;
                    break;
                }
            }
            if (cnt < 3) {
                num++;
            }
        }
        System.out.println(num);
        br.close();
    }

    private static boolean isMultiple(int target, int num) {
        return target % num == 0;
    }
}
