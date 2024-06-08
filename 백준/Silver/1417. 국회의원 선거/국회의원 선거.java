import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int myCnt = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n - 1; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while (!pq.isEmpty() && myCnt <= pq.peek()) {
            int poll = pq.poll();
            poll--;
            myCnt++;
            answer++;
            pq.add(poll);
        }
        System.out.println(answer);
        br.close();
    }
}
