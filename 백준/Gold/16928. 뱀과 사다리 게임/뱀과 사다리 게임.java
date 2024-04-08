import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 최소 몇 번만에 도착점에 도착할 수 있을까?
 * 사다리가 있는 칸이면 위로 올라간다.(y-1)
 * 뱀이 있는 칸이면 아래로 내려간다.(y+1)
 * 그밖엔 주사위 수만큼 옆으로 이동한다. 100 칸이 넘어가면 이동할 수 없다.
 * 목표: 1번칸 시작 -> 100번칸 도착
 */
public class Main {
    static ArrayList<ArrayList<Pair>> graph;
    static int[] dx = {1, 2, 3, 4, 5, 6};
    static boolean[] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = inputs[0]; // 사다리의 수 3
        int m = inputs[1]; // 뱀의 수 7
        graph = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            graph.add(new ArrayList<>());
        }

        // 사다리, 뱀 (그래프) 만들기
        for (int i = 0; i < n + m; i++) {
            int[] data = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int v1 = data[0];
            int v2 = data[1];
            graph.get(v1).add(new Pair(v2, 0));
        }
        answer = Integer.MAX_VALUE;
        visited = new boolean[101];
        bfs(new Pair(1, 0));

        System.out.println(answer);
        br.close();
    }

    static class Pair {
        int x;
        int len;

        public Pair(int x, int len) {
            this.x = x;
            this.len = len;
        }
    }

    private static void bfs(Pair pair) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(pair);
        visited[1] = true;

        while (!queue.isEmpty()) {
            Pair nowNode = queue.poll(); // 1 0

            for (int i = 0; i < 6; i++) {
                int x1 = nowNode.x + dx[i];
                if (!isMovable(x1)) {
                    continue;
                }

                if (x1 == 100) {
                    answer = Math.min(answer, nowNode.len + 1);
                }

                if (!visited[x1]) {
                    if (!graph.get(x1).isEmpty()) {
                        ArrayList<Pair> nodes = graph.get(x1);
                        for (Pair node : nodes) {
                            if (visited[node.x]) {
                                continue;
                            }
                            queue.add(new Pair(node.x, nowNode.len + 1));
                            visited[node.x] = true;
                        }
                    } else {
                        queue.add(new Pair(x1, nowNode.len + 1));
                        visited[x1] = true;
                    }
                }
            }
        }
    }

    private static boolean isMovable(int x) {
        return x > 0 && x < 101;
    }
}
