import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // k개의 로프를 사용해서 중량이 w인 물체를 들어올릴 때 -> w/k 중량이 걸리게 됨
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            int rope = Integer.parseInt(br.readLine());
            pq.add(rope);
        }

        // 임의로 몇 개의 로프를 골라서 사용해도 됨
        int answer = 0;
        int ropeCnt = 1;
        while (!pq.isEmpty()) {
            int poll = pq.poll();
            answer = Math.max(answer, poll * ropeCnt);
            ropeCnt++;
        }
        System.out.println(answer);
        br.close();
    }
}
