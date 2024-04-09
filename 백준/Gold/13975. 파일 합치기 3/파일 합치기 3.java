import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 파일 합치기 3
 * 우선순위큐 - 유망한 두 수를 합쳐서 다시 넣어줌(그리디)
 */
public class Main {

    static PriorityQueue<Long> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            pq = new PriorityQueue<>();
            int k = Integer.parseInt(br.readLine());
            long[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToLong(Long::parseLong)
                    .toArray();

            for (int j = 0; j < k; j++) {
                pq.add(inputs[j]);
            }

            long sum = 0;
            while (pq.size() > 1) {
                Long v1 = pq.poll();
                Long v2 = 0L;
                if (pq.peek() != null) {
                    v2 = pq.poll();
                }
                long twoSum = v1 + v2;
                sum += twoSum;
                pq.add(twoSum);
            }
            System.out.println(sum);
        }
        br.close();
    }
}
