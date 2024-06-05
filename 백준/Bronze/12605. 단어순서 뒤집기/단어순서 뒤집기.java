import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append("Case #").append(i).append(": ");
            String[] row = br.readLine().split(" ");
            for (int j = row.length - 1; j >= 0; j--) {
                sb.append(row[j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
