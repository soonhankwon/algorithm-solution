import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 들어갔을때 나의 앞차량보다 빨리나오면 추월한것
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(br.readLine());
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String result = br.readLine();
            if (!result.equals(queue.peek())) {
                queue.remove(result);
                cnt++;
                continue;
            }
            queue.poll();
        }
        System.out.println(cnt);
        br.close();
    }
}
