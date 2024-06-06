import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            PriorityQueue<School> pq = new PriorityQueue<>(Comparator.comparing(s -> -1 * s.consumption));
            for (int j = 0; j < n; j++) {
                String[] row = br.readLine().split(" ");
                pq.add(new School(row[0], Integer.parseInt(row[1])));
            }
            if (!pq.isEmpty()) {
                sb.append(pq.poll().name).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }

    private static class School {
        String name;
        int consumption;

        public School(String name, int consumption) {
            this.name = name;
            this.consumption = consumption;
        }
    }
}
