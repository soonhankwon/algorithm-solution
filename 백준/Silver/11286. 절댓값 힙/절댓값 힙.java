import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        // 절대값 힙!
        // 1. 배열에 정수 x를 넣음
        // 2. 배열에서 절대값이 가장 작은 값을 출력, 그 값을 배열에서 제거
        // 2.1 가장 작은 값이 여러개이면, 가장 작은수를 출력!
        // 3. x가 0이 아니라면 배열에 추가하는 연산
        // 4. x가 0이 라면 절댓값이 가장 작은 값을 출력하고 배열에서 제거하는 연산
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                Comparator.comparingInt((Integer i) -> Math.abs(i))
                        .thenComparing(i -> i)
        );
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input != 0) {
                queue.add(input);
                continue;
            }
            Integer poll = queue.poll();
            if (poll == null) {
                System.out.println(0);
                continue;
            }
            System.out.println(poll);
        }
        br.close();
    }
}
