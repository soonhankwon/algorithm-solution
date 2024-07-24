import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (row.length == 1) {
                if (pq.isEmpty()) {
                    sb.append(-1);
                } else {
                    sb.append(pq.poll());
                }
                sb.append("\n");
            } else {
                for (int j = 1; j <= row[0]; j++) {
                    pq.add(row[j]);
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}