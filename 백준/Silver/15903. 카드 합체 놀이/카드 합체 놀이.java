import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        // i번 카드엔 a_i가 쓰여있음
        // 1. x번 카드와 y번 카드를 골라 그 두장에 쓰여진 수를 더한 값을 출력
        // 2. 계산한 값을 x번 카드와 y번 카드 두장에 모두 덮어씀
        // 총 m번 플레이 -> 모두 끝난후 n장의 카드에 쓰여있는수를 모두 더한 값 -> 놀이점수
        // 점수를 가장 작게 만드는 것이 놀이 목표!

        // 0. 1 2 3 4
        // 1. 3 3 3 4
        // 2. 6 6 3 4
        // 3. 6 6 7 7
        // 4. 12 12 7 7

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = inputs[0];
        int m = inputs[1];
        long[] data = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            priorityQueue.add(data[i]);
        }

        int cnt = 0;
        while (cnt < m) {
            assert priorityQueue.peek() != null;
            long minNum1 = priorityQueue.poll();

            assert priorityQueue.peek() != null;
            long minNum2 = priorityQueue.poll();

            long minSum = minNum1 + minNum2;
            priorityQueue.add(minSum);
            priorityQueue.add(minSum);
            cnt++;
        }

        long sum = priorityQueue.stream()
                .mapToLong(Long::longValue)
                .sum();
        System.out.println(sum);
        br.close();
    }
}
