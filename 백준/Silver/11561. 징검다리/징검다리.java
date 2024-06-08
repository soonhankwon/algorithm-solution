import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        /*
         * 1 + 2 + 3 + 4 + ... + n 등차수열로 징검다리를 건너는게 최선
         * n(n+1) / 2 <= target
         * n(n+1) <= 2 * target
         * n^2 + n -(2 * target) <= 0
         * n = (-1 + Math.sqrt(1 + 8 * target)) / 2
         * n = Math.sqrt(8 * target) - 1 / 2
         * n = Math.sqrt(2 * target)
         */

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            long num = Long.parseLong(br.readLine());
            long res = binarySearch(num);
            sb.append(res).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static long binarySearch(long target) {
        long left = 1;
        long right = (long) Math.sqrt((2 * target));
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long prefixSum = (mid + 1) * mid / 2;
            // 누적합이 타겟보다 작으면 결과를 업데이트 해준다.(스텝 1개만 뛰면 목적지 도달가능)
            if (prefixSum <= target) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                // 누적합이 타겟보다 크면 범위를 낮춰준다.(목적지에 도달할 수 없다)
                right = mid - 1;
            }
        }
        return answer;
    }
}
