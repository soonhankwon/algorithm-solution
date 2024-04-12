import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = inputs[0]; // n명
        int k = inputs[1]; // k개의 조 -> k-1개의 나누는 선
        // 바로 인접한 원생과의 키 차이가 가장 크게 나는 곳 -> 해당 키 차이는 비용에서 제외된다!(중요 아이디어)

        // 조마다 티셔츠를 맞추는 비용은 조에서 가장 키가 큰 원생과 가장 키가 작은 원생의 키 차이!
        // 조별로 인원이 같을 필요는 없지만 1명은 있어야함!
        int[] data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 항상 원생들은 인접해있어야 하며 & 인접한 유치원생의 키 차이가 최소가 되도록
        // 키 차이가 큰 곳을 기준으로 나눈다!
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n - 1; i++) {
            pq.add(data[i + 1] - data[i]);
        }

        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }

        int sum = pq.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
        br.close();
    }
}
