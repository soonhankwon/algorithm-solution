import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

// eg) 수를 25개 넣음 -> 최소힙 사이즈가 5라면 -> 제일 작은 20개는 아웃됨 -> 인풋 넘버와 최소힙의 루트와 비교후 삽입
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .forEach(num -> {
                        if (pq.size() < n) {
                            pq.add(num);
                        } else if (num > pq.peek()) {
                            pq.poll();
                            pq.add(num);
                        }
                    });
        }
        System.out.println(pq.peek());
        br.close();
    }
}
