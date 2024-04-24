import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 포드-풀커슨 : 네트워크 플로 문제
 */
public class Main {

    static final int MAX_SIZE = 52;
    static int[][] capacity, flow;
    static int n, maxFlow, s, t = 25;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        capacity = new int[MAX_SIZE][MAX_SIZE];
        flow = new int[MAX_SIZE][MAX_SIZE];

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");

            int start = charToInt(inputs[0].charAt(0));
            int end = charToInt(inputs[1].charAt(0));
            int weight = Integer.parseInt(inputs[2]);

            // 무향 그래프
            capacity[start][end] += weight;
            capacity[end][start] += weight;
        }

        // 증가경로가 없을때까지 반복
        while (true) {
            visited = new boolean[MAX_SIZE];
            int flowAmount = dfs(s, Integer.MAX_VALUE);
            if (flowAmount == 0) {
                break;
            }
            maxFlow += flowAmount;
        }
        System.out.println(maxFlow);
        br.close();
    }

    private static int dfs(int from, int amount) {
        // 증가경로가 완성되면 해당 증가경로의 최소 잔여용량 리턴
        if (from == t) {
            return amount;
        }

        if (visited[from]) {
            return 0;
        }

        visited[from] = true;
        for (int i = 0; i < MAX_SIZE; i++) {
            // 유량이 흐를 수 있다면 - 여유 용량이 있다면
            if (capacity[from][i] > flow[from][i]) {
                int flowAmount = dfs(i, Math.min(amount, capacity[from][i] - flow[from][i]));
                // 잔여용량 갱신 후 리턴
                if (flowAmount > 0) {
                    flow[from][i] += flowAmount;
                    flow[i][from] -= flowAmount;
                    return flowAmount;
                }
            }
        }
        return 0;
    }

    private static int charToInt(char c) {
        if ('a' <= c && c <= 'z') {
            c -= 6;
        }
        return c - 65;
    }
}
