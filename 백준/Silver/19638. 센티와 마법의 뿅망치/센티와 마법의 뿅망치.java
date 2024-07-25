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

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < inputs[0]; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        Function<Integer, Integer> getHalf = i -> i / 2;
        int cnt = 0;
        int height = inputs[1];
        for (int i = 0; i < inputs[2]; i++) {
            Integer giant = pq.poll();
            if (giant == null || giant < height || giant == 1) {
                pq.add(giant);
                break;
            }
            cnt++;
            pq.add(getHalf.apply(giant));
        }

        String answer = "NO";
        if (!pq.isEmpty() && pq.peek() < height) {
            answer = "YES";
        }

        StringBuilder sb = new StringBuilder();
        if (answer.equals("YES")) {
            sb.append(answer).append("\n");
            sb.append(cnt);
            System.out.println(sb);
            return;
        }

        sb.append(answer).append("\n");
        sb.append(pq.poll());
        System.out.println(sb);
        br.close();
    }
}
