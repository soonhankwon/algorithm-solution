import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * 컴퓨터를 연결하는 비용을 최소! - 최소 신장 트리(MST)
 * 크루스칼 알고리즘
 */
public class Main {

    static int[] unionFind;
    static int v, e, useComputer, answer;
    static PriorityQueue<Computer> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine()); // 정점의 수
        e = Integer.parseInt(br.readLine()); // 간선의 수

        // 1.연결 성분의 초기화
        // 최소 단위 서로소 집합 만들기
        unionFind = new int[v + 1];
        for (int i = 0; i < v + 1; i++) {
            unionFind[i] = i;
        }

        // 2.간선을 가중치 오름차 순으로 정렬(간선 정렬)
        pq = new PriorityQueue<>();
        for (int i = 0; i < e; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int v1 = inputs[0];
            int v2 = inputs[1];
            int w = inputs[2];

            pq.add(new Computer(v1, v2, w));
        }

        // 3. 간선 추가(MST 만들기) 및 사이클 발생확인
        kruskal();
        System.out.println(answer);
        br.close();
    }

    private static void kruskal() {
        while (useComputer < v - 1) {
            if (pq.isEmpty()) {
                break;
            }
            Computer nowNode = pq.poll();
            // 3. 사이클 발생 여부 판단
            if (find(nowNode.startNode) != find(nowNode.endNode)) {
                union(nowNode.startNode, nowNode.endNode);
                answer = answer + nowNode.cost;
                useComputer++;
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

    private static class Computer implements Comparable<Computer> {
        int startNode;
        int endNode;
        int cost;

        @Override
        public int compareTo(Computer o) {
            return this.cost - o.cost;
        }

        public Computer(int startNode, int endNode, int cost) {
            this.startNode = startNode;
            this.endNode = endNode;
            this.cost = cost;
        }
    }
}
