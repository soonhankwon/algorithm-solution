import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = inputs[0]; // 인구수
        int h = inputs[1]; // 센티의키
        int t = inputs[2]; // 망치 횟수제한

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        String answer = "NO";
        Function<Integer, Integer> halfFunction = i -> i / 2;
        int cnt = 0;
        for (int i = 0; i < t; i++) {
            Integer giant = pq.poll();
            if (giant == null || giant < h || giant == 1) {
                pq.add(giant);
                break;
            }
            cnt++;
            pq.add(halfFunction.apply(giant));
        }

        if (!pq.isEmpty() && pq.peek() < h) {
            answer = "YES";
        }

        if (answer.equals("YES")) {
            System.out.println(answer);
            System.out.println(cnt);
            return;
        }
        System.out.println(answer);
        System.out.println(pq.poll());
        br.close();
    }
}
