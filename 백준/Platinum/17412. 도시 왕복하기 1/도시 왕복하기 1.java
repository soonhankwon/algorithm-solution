import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static class Edge {
        int to;       // 도착 정점
        int capacity; // 용량(1)
        int flow;     // 현재 흐르는 유량
        int rev;      // 역방향 간선의 인덱스 (유량 상쇄용)
        
        public Edge(int to, int capacity, int rev) {
            this.to = to;
            this.capacity = capacity;
            this.rev = rev;
            this.flow = 0;
        }
    }
    static int N,P;
    static List<List<Edge>> graph;
    static int[] level;
    static int[] work;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        N = Integer.parseInt(firstLine[0]);
        P = Integer.parseInt(firstLine[1]);
        
        // 그래프 초기화
        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 간선 입력
        for(int i = 0; i < P; i++) {
            String[] edgeInfo = br.readLine().split(" ");
            int u = Integer.parseInt(edgeInfo[0]);
            int v = Integer.parseInt(edgeInfo[1]);
            
            // 유량 그래프 구성: 정방향 용량 1
            graph.get(u).add(new Edge(v, 1, graph.get(v).size()));
            graph.get(v).add(new Edge(u, 0, graph.get(u).size() - 1));
        }
        System.out.println(dinic(1,2));
    }
    
    static int dinic(int source, int sink) {
        int totalFlow = 0;
        level = new int[N + 1];
        work = new int[N + 1];
        
        while(bfs(source, sink)) {
            Arrays.fill(work, 0);
            while(true) {
                int flow = dfs(source, sink, Integer.MAX_VALUE);
                if(flow == 0) break;
                totalFlow += flow;
            }
        }
        return totalFlow;
    }
    
    static boolean bfs(int source, int sink) {
        Arrays.fill(level, -1);
        level[source] = 0;
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(source);
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(Edge next: graph.get(cur)) {
                if(next.capacity - next.flow > 0 && level[next.to] == -1) {
                    level[next.to] = level[cur] + 1;
                    q.offer(next.to);
                }
            }
        }
        return level[sink] != -1;
    }
    
    static int dfs(int cur, int sink, int maxFlow) {
        if(cur == sink) return maxFlow;
        
        for(int i = work[cur]; i < graph.get(cur).size(); i++) {
            Edge edge = graph.get(cur).get(i);
            work[cur] = i;
            
            if(level[edge.to] == level[cur] + 1 && edge.capacity - edge.flow > 0) {
                int push = dfs(edge.to, sink, Math.min(maxFlow, edge.capacity - edge.flow));
                
                if(push > 0) {
                    edge.flow += push;
                    graph.get(edge.to).get(edge.rev).flow -= push;
                    return push;
                }
            }
        }
        return 0;
    }
}