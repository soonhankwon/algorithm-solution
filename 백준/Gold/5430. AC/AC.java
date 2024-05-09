import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            boolean isError = false;
            String operation = br.readLine();
            br.readLine();
            String input = br.readLine();
            char[] chars = operation.toCharArray();

            deque = new ArrayDeque<>();
            int inputLength = input.length();
            if (inputLength > 2) {
                String[] split = input.substring(1, inputLength - 1).split(",");
                for (String s : split) {
                    deque.addLast(Integer.parseInt(s));
                }
            }

            boolean isReversed = false;
            for (char ch : chars) {
                if (ch == 'R') {
                    isReversed = !isReversed;
                    continue;
                }
                if (ch == 'D') {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if (isReversed) {
                        deque.pollLast();
                        continue;
                    }
                    deque.pollFirst();
                } else {
                    isError = true;
                    break;
                }
            }
            if (isError) {
                sb.append("error\n");
            } else {
                print(isReversed);
            }
        }
        System.out.println(sb);
        br.close();
    }

    private static void print(boolean isReversed) {

        if (deque.isEmpty()) {
            sb.append("[]\n");
            return;
        }
        sb.append("[");
        int size = deque.size();
        if (isReversed) {
            for (int i = 0; i < size - 1; i++) {
                sb.append(deque.pollLast()).append(",");
            }
        } else {
            for (int i = 0; i < size - 1; i++) {
                sb.append(deque.pollFirst()).append(",");
            }
        }
        sb.append(deque.poll()).append("]\n");
    }
}
