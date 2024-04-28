import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Coordinate> pq = new PriorityQueue<>(Comparator.comparingInt(Coordinate::getY)
                .thenComparing(c -> c.x));
        for (int i = 0; i < n; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            pq.add(new Coordinate(inputs[0], inputs[1]));
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Coordinate poll = pq.poll();
            sb.append(poll.x).append(" ").append(poll.y).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static class Coordinate {
        int x;
        int y;

        public int getY() {
            return this.y;
        }

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
