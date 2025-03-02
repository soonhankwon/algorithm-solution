import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(pq::add);
        int time = 0;
        int answer = 0;
        while (!pq.isEmpty()) {
            time = pq.poll() + time;
            answer += time;
        }
        System.out.println(answer);
        br.close();
    }
}
