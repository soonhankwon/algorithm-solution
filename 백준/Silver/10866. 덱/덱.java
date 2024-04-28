import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    static ArrayDeque<Integer> deque;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        deque = new ArrayDeque<>();
        sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            String operation = inputs[0];
            if (operation.equals("push_front")) {
                pushFront(Integer.parseInt(inputs[1]));
                continue;
            }
            if (operation.equals("push_back")) {
                pushBack(Integer.parseInt(inputs[1]));
                continue;
            }
            if (operation.equals("pop_front")) {
                popFront();
                continue;
            }
            if (operation.equals("pop_back")) {
                popBack();
                continue;
            }
            if (operation.equals("size")) {
                size();
                continue;
            }
            if (operation.equals("empty")) {
                empty();
                continue;
            }
            if (operation.equals("front")) {
                front();
                continue;
            }
            back();
        }
        System.out.println(sb);
        br.close();
    }

    private static void pushFront(int n) {
        deque.addFirst(n);
    }

    private static void pushBack(int n) {
        deque.addLast(n);
    }

    private static void popFront() {
        sb.append(deque.isEmpty() ? "-1\n" : deque.pollFirst() + "\n");
    }

    private static void popBack() {
        sb.append(deque.isEmpty() ? "-1\n" : deque.pollLast() + "\n");
    }

    private static void size() {
        sb.append(deque.size()).append("\n");
    }

    private static void empty() {
        sb.append(deque.isEmpty() ? "1\n" : "0\n");
    }

    private static void front() {
        sb.append(deque.isEmpty() ? "-1\n" : deque.peekFirst() + "\n");
    }

    private static void back() {
        sb.append(deque.isEmpty() ? "-1\n" : deque.peekLast() + "\n");
    }
}
