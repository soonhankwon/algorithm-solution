import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        // 집중국 갯수 >= 센서 갯수 예외처리
        if (k >= n) {
            System.out.println(0);
            return;
        }

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        // 센서간의 거리 차이 배열 - 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n - 1; i++) {
            pq.add(arr[i + 1] - arr[i]);
        }
        int sum = 0;
        // 거리 차이배열 -> (n - k) 집중국이 커버할 센서 거리
        for (int i = 0; i < n - k; i++) {
            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }
        System.out.println(sum);
        br.close();
    }
}
