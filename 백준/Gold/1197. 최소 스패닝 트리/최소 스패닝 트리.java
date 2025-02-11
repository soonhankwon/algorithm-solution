import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static int[] par;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        par = new int[arr[0] + 1];
        for (int i = 1; i <= arr[0]; i++) {
            par[i] = i;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparing(e -> e.weight));
        for (int i = 1; i <= arr[1]; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            pq.add(new Edge(row[0], row[1], row[2]));
        }
        int answer = 0;
        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (find(now.startNode) != find(now.endNode)) {
                union(now.startNode, now.endNode);
                answer += now.weight;
            }
        }
        System.out.println(answer);
        br.close();
    }

    private static int find(int a) {
        return a == par[a] ? a : (par[a] = find(par[a]));
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            par[b] = a;
        }
    }

    public static class Edge {
        int startNode, endNode, weight;

        public Edge(int startNode, int endNode, int weight) {
            this.startNode = startNode;
            this.endNode = endNode;
            this.weight = weight;
        }
    }
}