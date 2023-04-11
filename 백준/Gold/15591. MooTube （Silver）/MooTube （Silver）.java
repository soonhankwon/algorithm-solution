import java.util.*;

public class Main {
    static ArrayList<Edge>[] graph;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); //node number
        int Q = scanner.nextInt(); //edge number

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int usado = scanner.nextInt();
            graph[start].add(new Edge(end, usado));
            graph[end].add(new Edge(start, usado));
        }

        for (int i = 0; i < Q; i++) {
            int k = scanner.nextInt();
            int v = scanner.nextInt();

            Queue<Edge> queue = new LinkedList<>();
            queue.add(new Edge(v, 0));
            visited = new boolean[N + 1];
            visited[v] = true;

            int count = 0;
            while (!queue.isEmpty()) {
                Edge current = queue.poll();
                int currentNode = current.node;
                for(Edge e : graph[currentNode]) {
                    if(!visited[e.node] && e.usado >= k) {
                        queue.add(e);
                        visited[e.node] = true;
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}

class Edge {
    int node;
    int usado;

    public Edge(int node, int usado) {
        this.node = node;
        this.usado = usado;
    }
}