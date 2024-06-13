import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int place = 1;
        long sum = 0;
        while (!pq.isEmpty()) {
            int expectedPlace = pq.poll();
            sum += Math.abs(expectedPlace - place);
            place++;
        }
        System.out.println(sum);
        br.close();
    }
}
