import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<String> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.add(br.readLine());
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String res = br.readLine();
            if (!res.equals(queue.peek())) {
                queue.remove(res);
                cnt++;
                continue;
            }
            queue.poll();
        }
        System.out.println(cnt);
        br.close();
    }
}
