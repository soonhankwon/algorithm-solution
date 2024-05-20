import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * MST - Kruskal
 */
public class Main {

    static int n, useStar;
    static double answer;
    static PriorityQueue<Edge> pq;
    static int[] unionFind;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 정점의 수

        // 최소 단위 서로소 집합 만들기
        unionFind = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            unionFind[i] = i;
        }

        Star[] stars = new Star[n];
        for (int i = 0; i < n; i++) {
            double[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            double x = row[0];
            double y = row[1];
            stars[i] = new Star(x, y, i);
        }
        // 간선을 가중치 오름차 순으로 정렬
        pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Star star1 = stars[i];
                Star star2 = stars[j];
                double cost = Math.sqrt(Math.pow(star1.x - star2.x, 2) + Math.pow(star1.y - star2.y, 2));
                pq.add(new Edge(stars[i].id, stars[j].id, cost));
            }
        }
        kruskal();
        System.out.println(answer);
        br.close();
    }

    private static void kruskal() {
        while (useStar < n - 1) {
            if (pq.isEmpty()) {
                break;
            }
            Edge nowNode = pq.poll();
            // 사이클 발생 여부 판단
            int startNode = nowNode.startNode;
            int endNode = nowNode.endNode;
            if (find(startNode) != find(endNode)) {
                union(startNode, endNode);
                answer = answer + nowNode.cost;
                useStar++;
            }
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            unionFind[b] = a;
        }
    }

    private static int find(int a) {
        if (a == unionFind[a]) {
            return a;
        }
        return unionFind[a] = find(unionFind[a]);
    }

    private static class Star {
        double x;
        double y;
        int id;

        public Star(double x, double y, int id) {
            this.x = x;
            this.y = y;
            this.id = id;
        }
    }

    private static class Edge implements Comparable<Edge> {
        int startNode;
        int endNode;
        double cost;

        public Edge(int startNode, int endNode, double cost) {
            this.startNode = startNode;
            this.endNode = endNode;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return (int) (this.cost - o.cost);
        }
    }
}
