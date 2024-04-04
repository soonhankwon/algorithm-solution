import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        // N * N 표(정사각형)
        // n번째 큰 수를 찾는 프로그램
        // 일단 모든 값을 입력받아야 알 수 있다.
        // 우선순위 큐(Min Heap) -> reverse -> 삽입에 O(logN) + 맨앞 조회 O(1)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < n; j++) {
                priorityQueue.add(inputs[j]);
            }
        }

        int cnt = 0;
        int answer = 0;
        while (cnt < n) {
            assert priorityQueue.peek() != null;
            int poll = priorityQueue.poll();
            cnt++;
            if (cnt == n) {
                answer = poll;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
