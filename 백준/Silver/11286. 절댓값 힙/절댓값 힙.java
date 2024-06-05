import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt((Integer i) -> Math.abs(i))
                .thenComparingInt(i -> i));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int operation = Integer.parseInt(br.readLine());
            if (operation != 0) {
                pq.add(operation);
                continue;
            }
            if (!pq.isEmpty()) {
                sb.append(pq.poll());
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
