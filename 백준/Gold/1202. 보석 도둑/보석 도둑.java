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

        int n = inputs[0]; // 보석의 수
        int k = inputs[1]; // 가방의 수

        Jewel[] jewels = new Jewel[n];
        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            jewels[i] = new Jewel(row[0], row[1]);
        }

        PriorityQueue<Integer> bags = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }

        Arrays.sort(jewels);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long answer = 0;
        int jewelIndex = 0;
        while (!bags.isEmpty()) {
            Integer nowBag = bags.poll();
            // 현재 가방의 무게를 수용할 수 있는 모든 보석을 우선순위 큐에 추가
            while (jewelIndex < n && jewels[jewelIndex].weight <= nowBag) {
                pq.add(jewels[jewelIndex].price);
                jewelIndex++;
            }

            // 우선순위 큐에서 가장 가격이 높은 보석을 넣음
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }
        System.out.println(answer);
        br.close();
    }

    private static class Jewel implements Comparable<Jewel> {
        int weight;
        int price;

        public Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        // 무게 오름차순으로 정렬(가방을 오름차순 정렬했기 때문), 무게가 같다면 가격으로 내림차순 정렬
        @Override
        public int compareTo(Jewel o) {
            if (this.weight == o.weight) {
                return o.price - this.price;
            }
            return this.weight - o.weight;
        }
    }
}
