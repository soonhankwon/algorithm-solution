import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 데이터 t개
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            // 카드의 개수 n
            int n = Integer.parseInt(br.readLine());
            Deque<Character> deque = new LinkedList<>();
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (deque.isEmpty()) {
                    deque.add(input[j].charAt(0));
                    continue;
                }
                char nextCardChar = input[j].charAt(0);
                if (nextCardChar <= deque.getFirst()) {
                    deque.addFirst(nextCardChar);
                } else {
                    deque.addLast(nextCardChar);
                }
            }
            while (deque.size() != 0) {
                sb.append(deque.poll());
            }
            sb.append('\n');
        }
        br.close();
        System.out.println(sb);
    }
}