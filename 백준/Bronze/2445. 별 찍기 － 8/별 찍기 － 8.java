import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int spaceCount = 2 * n - 2;
        for (int i = 1; i <= n; i++) {
            sb.append("*".repeat(i));
            sb.append(" ".repeat(spaceCount));
            sb.append("*".repeat(i));
            sb.append("\n");
            if (spaceCount == 0) {
                spaceCount += 2;
                break;
            }
            spaceCount -= 2;
        }
        for (int i = n - 1; i > 0; i--) {
            sb.append("*".repeat(i));
            sb.append(" ".repeat(spaceCount));
            sb.append("*".repeat(i));
            if (i != 1) {
                sb.append("\n");
            }
            spaceCount += 2;
        }
        System.out.println(sb);
        br.close();
    }
}
