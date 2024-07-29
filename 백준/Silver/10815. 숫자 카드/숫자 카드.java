import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        boolean[] hasNumber = new boolean[20_000_001];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            hasNumber[Integer.parseInt(input[i]) + 10_000_000] = true;
        }

        int m = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            sb.append(hasNumber[Integer.parseInt(input[i]) + 10_000_000] ? "1 " : "0 ");
        }
        System.out.println(sb);
        br.close();
    }
}
