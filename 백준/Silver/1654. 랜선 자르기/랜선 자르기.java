import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 이분탐색 + 파라메트릭 서치
public class Main {

    static List<Integer> arr;
    static int k, target;
    static long max, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        arr = new ArrayList<>();
        k = inputs[0];
        target = inputs[1];
        max = -1;
        answer = -1;
        for (int i = 0; i < k; i++) {
            int input = Integer.parseInt(br.readLine());
            max = Math.max(max, input);
            arr.add(input);
        }
        binarySearch();
        System.out.println(answer);
        br.close();
    }

    private static void binarySearch() {
        long start = 1;
        long end = max;
        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;
            for (Integer e : arr) {
                sum += e / mid;
            }
            if (sum >= target) {
                answer = Math.max(answer, mid);
                start = mid + 1;
                continue;
            }
            end = mid - 1;
        }
    }
}
