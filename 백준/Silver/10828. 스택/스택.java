import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static Stack<Integer> stack;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        stack = new Stack<>();
        sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            String operation = inputs[0];
            if (operation.equals("push")) {
                push(Integer.parseInt(inputs[1]));
                continue;
            }
            if (operation.equals("pop")) {
                pop();
                continue;
            }
            if (operation.equals("size")) {
                size();
                continue;
            }
            if (operation.equals("top")) {
                top();
                continue;
            }
            empty();
        }
        System.out.println(sb);
        br.close();
    }

    private static void push(int n) {
        stack.push(n);
    }

    private static void pop() {
        sb.append(stack.isEmpty() ? "-1\n" : stack.pop() + "\n");
    }

    private static void empty() {
        sb.append(stack.isEmpty() ? "1\n" : "0\n");
    }

    private static void size() {
        sb.append(stack.size()).append("\n");
    }

    private static void top() {
        sb.append(stack.isEmpty() ? "-1\n" : stack.peek() + "\n");
    }
}
