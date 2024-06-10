import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static List<ArrayList<City>> graph;
    static boolean[] visited;
    static int target;
    static List<Integer> res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = inputs[0];
        int m = inputs[1];
        target = inputs[2];
        int start = inputs[3];

        graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int v1 = row[0];
            int v2 = row[1];
            graph.get(v1).add(new City(v2, 0));
        }

        visited = new boolean[n + 1];
        res = new ArrayList<>();
        bfs(new City(start, 0));
        if (res.isEmpty()) {
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        res.stream().sorted().forEach((r -> sb.append(r).append("\n")));
        System.out.println(sb);
        br.close();
    }

    private static void bfs(City startCity) {
        Queue<City> queue = new LinkedList<>();
        queue.add(startCity);
        visited[startCity.node] = true;

        while (!queue.isEmpty()) {
            City nowCity = queue.poll();
            int distance = nowCity.len;
            if (distance == target) {
                res.add(nowCity.node);
            }
            ArrayList<City> adjNodes = graph.get(nowCity.node);
            for (City city : adjNodes) {
                int node = city.node;
                if (!visited[node]) {
                    queue.add(new City(node, distance + 1));
                    visited[node] = true;
                }
            }
        }
    }

    private static class City {
        int node;
        int len;

        public City(int node, int len) {
            this.node = node;
            this.len = len;
        }
    }
}
