import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        //1. 대기열1: 큐
        //2. 대기열2: 스택
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<>();
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < n; i++) {
            int input = inputs[i];
            queue.add(input);
        }

        Stack<Integer> stack = new Stack<>();
        int now = 1;
        while (!queue.isEmpty()) {
            if (queue.peek() == now) {
                queue.poll();
                now++;
                continue;
            }
            // 스택이 비어있지 않고 번호표가 같다면 pop
            if (!stack.isEmpty() && stack.peek() == now) {
                stack.pop();
                now++;
                continue;
            }
            stack.push(queue.poll());
        }

        String answer = "Nice";
        while (!stack.isEmpty()) {
            if (stack.peek() == now) {
                stack.pop();
                now++;
                continue;
            }
            System.out.println("Sad");
            return;
        }
        System.out.println(answer);
        br.close();
    }
}
