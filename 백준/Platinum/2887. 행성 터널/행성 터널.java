import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

/*
 * 최소 스패닝 트리
 * 크루스칼 알고리즘
 */
public class Main {

    static int n, usePlanet, answer;
    static List<Planet> planets;
    static PriorityQueue<Edge> pq;
    static int[] unionFind;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        planets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            planets.add(new Planet(i, row[0], row[1], row[2]));
        }

        pq = new PriorityQueue<>();
        // x좌표 기준으로 정렬
        planets.sort(Comparator.comparingInt(i -> i.x));
        for (int i = 1; i < n; i++) {
            Planet planet1 = planets.get(i);
            Planet planet2 = planets.get(i - 1);
            int cost = planet1.x - planet2.x;
            pq.add(new Edge(planet1.id, planet2.id, cost));
        }

        // y좌표를 기준으로 정렬
        planets.sort(Comparator.comparingInt(i -> i.y));
        for (int i = 1; i < n; i++) {
            Planet planet1 = planets.get(i);
            Planet planet2 = planets.get(i - 1);
            int cost = planet1.y - planet2.y;
            pq.add(new Edge(planet1.id, planet2.id, cost));
        }

        // z좌표를 기준으로 정렬
        planets.sort(Comparator.comparingInt(i -> i.z));
        for (int i = 1; i < n; i++) {
            Planet planet1 = planets.get(i);
            Planet planet2 = planets.get(i - 1);
            int cost = planet1.z - planet2.z;
            pq.add(new Edge(planet1.id, planet2.id, cost));
        }

        // 1. 연결 성분 초기화: 최소 단위 서로소 집합 만들기
        unionFind = new int[n + 1];
        IntStream.range(0, n + 1).forEach(i -> unionFind[i] = i);
        kruskal();
        System.out.println(answer);
        br.close();
    }

    private static void kruskal() {
        while (usePlanet < n - 1) {
            if (pq.isEmpty()) {
                break;
            }
            Edge nowEdge = pq.poll();
            if (union(nowEdge.startNode, nowEdge.endNode)) {
                answer = answer + nowEdge.cost;
                usePlanet++;
            }
        }
    }

    private static int find(int num) {
        if (unionFind[num] == num) {
            return num;
        }
        return unionFind[num] = find(unionFind[num]);
    }

    private static boolean union(int num1, int num2) {
        int numA = find(num1);
        int numB = find(num2);
        if (numA == numB) {
            return false;
        }
        unionFind[numB] = numA;
        return true;
    }

    private static class Planet {
        int id;
        int x;
        int y;
        int z;

        public Planet(int id, int x, int y, int z) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static class Edge implements Comparable<Edge> {
        int startNode;
        int endNode;
        int cost;

        public Edge(int startNode, int endNode, int cost) {
            this.startNode = startNode;
            this.endNode = endNode;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
