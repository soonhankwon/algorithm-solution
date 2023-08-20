import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            long passwordKey = Long.parseLong(br.readLine());
            for (int j = 2; j <= 1_000_000; j++) {
                if (passwordKey % j == 0) {
                    System.out.println("NO");
                    break;
                }
                if (j == 1_000_000)
                    System.out.println("YES");
            }
        }
    }
}