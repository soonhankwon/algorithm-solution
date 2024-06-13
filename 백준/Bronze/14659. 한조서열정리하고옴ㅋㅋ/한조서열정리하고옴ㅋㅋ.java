import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] mountains = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] cntArr = new int[n];
        int max = 0, answer = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                max = mountains[i];
                continue;
            }
            if (mountains[i] < max) {
                cntArr[i] = cntArr[i - 1] + 1;
            } else {
                max = mountains[i];
                cntArr[i] = 0;
            }
            answer = Math.max(answer, cntArr[i]);
        }
        System.out.println(answer);
        br.close();
    }
}
