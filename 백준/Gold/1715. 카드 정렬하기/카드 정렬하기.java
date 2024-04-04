import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        // 카드묶음 A,B
        // min heap
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            priorityQueue.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while (priorityQueue.size() > 1) {
            int sum = priorityQueue.poll() + priorityQueue.poll();
            answer += sum;
            priorityQueue.add(sum);
        }
        System.out.println(answer);
        br.close();
    }
}
