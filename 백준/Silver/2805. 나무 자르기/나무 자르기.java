import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] trees = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .sorted()
                .toArray();

        // 10 15 17 20
        long start = 0;
        long end = trees[n - 1];
        // 이분탐색 활용
        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = Arrays.stream(trees)
                    .filter(i -> i > mid)
                    .mapToLong(i -> i - mid)
                    .sum();
            // 자른 나무 합계가 요구치 이상인 경우 start 포인터 up
            if (sum >= m) {
                start = mid + 1;
            }
            // 자른 나무 합계가 요구치 미만인 경우 end 포인터 down
            else {
                end = mid - 1;
            }
        }
        System.out.println(end);
    }
}
