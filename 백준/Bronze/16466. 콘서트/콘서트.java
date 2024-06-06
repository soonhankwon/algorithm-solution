import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toCollection(PriorityQueue::new));

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (!pq.isEmpty()) {
                int min = pq.poll();
                if (i != min) {
                    answer = i;
                    break;
                }
            }
        }
        System.out.println(answer == 0 ? n + 1 : answer);
        br.close();
    }
}
