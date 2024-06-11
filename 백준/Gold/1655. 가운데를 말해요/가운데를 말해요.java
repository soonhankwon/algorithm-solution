import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (maxHeap.size() <= minHeap.size()) {
                maxHeap.add(input);
            } else {
                minHeap.add(input);
            }

            // 최소힙의 루트보다 최대힙의 루트가 크면 교환 - 절반의 큰 수는 최소힙으로 / 작은 수는 최대힙으로
            // -> 최대힙의 루트 {1,2,3,[4]} - [ 중간 ] - 최소힙의 루트 {[5],6,7,8}
            if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                int maxHeapRoot = maxHeap.poll();
                int minHeapRoot = minHeap.poll();

                maxHeap.add(minHeapRoot);
                minHeap.add(maxHeapRoot);
            }

            if (maxHeap.size() > minHeap.size()) {
                sb.append(maxHeap.peek()).append("\n");
            } else {
                sb.append(Math.min(maxHeap.peek(), minHeap.peek())).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
