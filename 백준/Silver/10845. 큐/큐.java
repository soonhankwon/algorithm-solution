import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int last = 0;
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            String operation = inputs[0];
            if (operation.equals("push")) {
                int input = Integer.parseInt(inputs[1]);
                queue.offer(input);
                last = input;
                continue;
            }

            if (operation.equals("pop")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                    continue;
                }
                int poll = queue.poll();
                sb.append(poll).append("\n");
                continue;
            }

            if (operation.equals("size")) {
                sb.append(queue.size()).append("\n");
                continue;
            }

            if (operation.equals("empty")) {
                if (queue.isEmpty()) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
                continue;
            }

            if (operation.equals("front")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                    continue;
                }
                sb.append(queue.peek()).append("\n");
                continue;
            }

            if (operation.equals("back")) {
                if (queue.isEmpty()) {
                    sb.append(-1).append("\n");
                    continue;
                }
                sb.append(last).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
