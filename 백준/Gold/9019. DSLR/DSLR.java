import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static StringBuilder sb;
    static int target;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int input = row[0];
            target = row[1];
            visited = new boolean[10_001];
            String result = bfs(new Number(input, ""), target);
            sb.append(result).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static String bfs(Number num, int target) {
        Queue<Number> queue = new LinkedList<>();
        queue.add(num);
        visited[num.num] = true;
        while (!queue.isEmpty()) {
            Number now = queue.poll();
            if (now.num == target) {
                return now.commands;
            }

            int numD = operationD(now.num);
            if (!visited[numD]) {
                queue.add(new Number(numD, now.commands + 'D'));
                visited[numD] = true;
            }

            int numS = operationS(now.num);
            if (!visited[numS]) {
                queue.add(new Number(numS, now.commands + 'S'));
                visited[numS] = true;
            }

            int numL = operationL(now.num);
            if (!visited[numL]) {
                queue.add(new Number(numL, now.commands + 'L'));
                visited[numL] = true;
            }

            int numR = operationR(now.num);
            if (!visited[numR]) {
                queue.add(new Number(numR, now.commands + 'R'));
                visited[numR] = true;
            }
        }
        return null;
    }

    private static class Number {
        int num;
        String commands;

        public Number(int num, String commands) {
            this.num = num;
            this.commands = commands;
        }
    }
    private static int operationD(int num) {
        int n = num * 2;
        if (n > 9999) {
            return n % 10000;
        }
        return n;
    }
    

    private static int operationS(int num) {
        if (num == 0) {
            return 9999;
        }
        return num - 1;
    }

    private static int operationL(int num) {
        return (num % 1000) * 10 + num / 1000;
    }

    private static int operationR(int num) {
        return (num % 10) * 1000 + num / 10;
    }
}
