import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 7개 숫자중 3개를 뽑는 조합 -> 7! / (7-3)! * 3!
        // 7 * 6 * 5 / 3 * 2
        long cnt = ((long) (n - 2) * (n - 1) * n) / 6;
        System.out.println(cnt + "\n" + 3);
        br.close();
    }
}