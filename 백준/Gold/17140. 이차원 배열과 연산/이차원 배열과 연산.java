import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    static int r, c, k;
    static int[][] arr = new int[101][101];
    static int xLength = 3, yLength = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        r = Integer.parseInt(inputs[0]);
        c = Integer.parseInt(inputs[1]);
        k = Integer.parseInt(inputs[2]);

        for (int i = 1; i <= 3; i++) {
            String[] rows = br.readLine().split(" ");
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = Integer.parseInt(rows[j - 1]);
            }
        }

        System.out.println(solution());
        br.close();
    }

    static int solution() {
        for (int i = 0; i <= 100; i++) {
            if (arr[r][c] == k) {
                return i;
            }
            operate();
        }
        return -1;
    }

    static void operate() {
        if (xLength >= yLength) {
            for (int i = 1; i <= xLength; i++) {
                operateR(i);
            }
        } else {
            for (int i = 1; i <= yLength; i++) {
                operateC(i);
            }
        }
    }

    // 각 숫자들의 개수를 구해서 HashMap 에 저장후 우선순위 큐에 옮겨서 정렬
    // 각 숫자들의 개수를 구해서 HashMap 에 담았다가 우선순위 큐에 옮겨담아서 정렬
    static void operateR(int key) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>(); // <number, count>

        for (int i = 1; i <= yLength; i++) {
            if (arr[key][i] == 0) {
                continue;
            }
            map.compute(arr[key][i], (num, count) -> count == null ? 1 : count + 1);
        }

        map.forEach((k, v) -> pq.add(new Pair(k, v)));

        int i = 1;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            arr[key][i++] = p.num;
            arr[key][i++] = p.cnt;
        }

        yLength = Math.max(yLength, i);

        while (i <= 99) {
            arr[key][i++] = 0;
            arr[key][i++] = 0;
        }
    }

    // 각 숫자들의 개수를 구해서 HashMap 에 담았다가 우선순위 큐에 옮겨담아서 정렬
    static void operateC(int key) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>(); // <number, count>

        for (int i = 1; i <= xLength; i++) {
            if (arr[i][key] == 0) {
                continue;
            }
            map.compute(arr[i][key], (num, count) -> count == null ? 1 : count + 1);
        }

        map.forEach((k, v) -> pq.add(new Pair(k, v)));

        int i = 1;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            arr[i++][key] = p.num;
            arr[i++][key] = p.cnt;
        }

        xLength = Math.max(xLength, i);

        while (i <= 99) {
            arr[i++][key] = 0;
            arr[i++][key] = 0;
        }
    }

    static class Pair implements Comparable<Pair> {
        int num;
        int cnt;

        public Pair(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.cnt > o.cnt) {
                return 1;
            } else if (this.cnt == o.cnt) {
                return this.num - o.num;
            } else {
                return -1;
            }
        }
    }
}
