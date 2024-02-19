import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

//다익스트라
public class Main {

    static class Node implements Comparable<Node> {
        int vertex, value;

        public Node(int vertex, int value) {
            this.vertex = vertex;
            this.value = value;
        }

        @Override
        public int compareTo(Node n) {
            if (this.value > n.value) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    static int v, e;

    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        v = Integer.parseInt(inputs[0]); //5 node count
        e = Integer.parseInt(inputs[1]); //6 edge count
        int startNodeNumber = Integer.parseInt(br.readLine()); //1

        graph = new ArrayList[v + 1];
        for (int i = 1; i <= v; i++) {
            graph[i] = new ArrayList<>();
        }

        dist = new int[v + 1];
        for (int i = 0; i <= v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++) {
            String[] graphInputs = br.readLine().split(" ");
            int u = Integer.parseInt(graphInputs[0]);
            int v = Integer.parseInt(graphInputs[1]);
            int w = Integer.parseInt(graphInputs[2]);
            graph[u].add(new Node(v, w));
        }

        visited = new boolean[v + 1];
        bfs(new Node(startNodeNumber, 0));
    }

    private static void bfs(Node startNode) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(startNode);
        dist[startNode.vertex] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int vertex = node.vertex;
            if (visited[vertex]) {
                continue;
            }
            visited[vertex] = true;
            int size = graph[vertex].size();
            for (int i = 0; i < size; i++) {
                Node tempNode = graph[vertex].get(i);
                int next = tempNode.vertex;
                int value = tempNode.value;

                if (dist[next] > dist[vertex] + value) {
                    dist[next] = value + dist[vertex];
                    queue.add(new Node(next, dist[next]));
                }
            }
        }
        for (int i = 1; i <= v; i++) {
            if (visited[i]) {
                System.out.println(dist[i]);
            } else {
                System.out.println("INF");
            }
        }
    }
}
