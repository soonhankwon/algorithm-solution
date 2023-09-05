import java.util.ArrayList;

class Solution {
    
    private static ArrayList<Integer>[] graph;
    
    public int solution(int n, int[][] wires) {
        // n 개의 송전탑이 전선을 통해 하나의 트리 형태로 연결되어 있다!
        // 전선들 중 하나를 끊어서 현재의 전력망 네트워크를 2개로 분할
        // 두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게
        // 두 전력망이 가지고 있는 송전탑 개수의 차이

        graph = new ArrayList[n + 1];
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            boolean[] visited = new boolean[n + 1];

            // 해당 간선을 그래프에서 제거
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));

            int count = dfs(1, visited);
            int abs = Math.abs(count - (n - count));
            min = Math.min(min, abs);

            // 해당 간선을 그래프에 다시 추가
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        return min;
    }
    
    private static int dfs(int index, boolean[] visited) {
        visited[index] = true;
        int cnt = 1;

        for (Integer next : graph[index]) {
            if (!visited[next])
                cnt += dfs(next, visited);
        }
        return cnt;
    }
}