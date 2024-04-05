import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        //누적합 + 그리디(맨앞에 가장 시간이 적게 걸리는 사람이 와야함)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] prefixSum = new int[n];
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        //삽입시 시간복잡도 logN
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(inputs[i]);
        }

        int index = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            int poll = pq.poll();
            if (index == 0) {
                prefixSum[index] = poll;
                cnt += poll;
                index++;
                continue;
            }
            prefixSum[index] = prefixSum[index - 1] + poll;
            cnt += prefixSum[index];
            index++;
        }
        System.out.println(cnt);
        br.close();
    }
}
