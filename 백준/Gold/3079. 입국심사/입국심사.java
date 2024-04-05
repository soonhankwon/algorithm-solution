import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 심사대에서는 한 번에 한 사람만 심사가능
        // 어떻게 심사를 받으면 모든 사람이 심사를 받는데 걸리는 시간이 최소?
        // 1. 가장 오래걸리는 시간? -> 가장 오래 걸리는 계산대 * m
        // 2. 시간의 범위 -> 1 ~ 가장 오래 걸리는 계산대 * m
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = inputs[0]; // 입국심사대의 수
        long m = inputs[1]; // 사람의 수 - 10억

        int[] checkPoint = new int[n];
        for (int i = 0; i < n; i++) {
            checkPoint[i] = Integer.parseInt(br.readLine());
        }
        //Quick Sort - o(nlogn) - 계산대에서 걸리는 시간 정렬
        Arrays.sort(checkPoint);

        long res = Long.MAX_VALUE;
        long min = 0;
        long max = m * checkPoint[checkPoint.length - 1];
        while (min <= max) {
            // 이분탐색
            long mid = (min + max) / 2;
            long sum = 0;
            for (long checkTime : checkPoint) {
                // mid 초 내에 해당 심사대에서 심사받을 수 있는 최대 인원 수
                long cnt = mid / checkTime;

                if (sum >= m) {
                    break;
                }
                sum += cnt;
            }
            
            if (sum >= m) {
                max = mid - 1;
                res = Math.min(mid, res);
            } else {
                min = mid + 1;
            }
        }

        System.out.println(res);
    }
}
