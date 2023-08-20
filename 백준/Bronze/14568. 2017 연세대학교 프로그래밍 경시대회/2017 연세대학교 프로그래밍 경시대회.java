import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for (int i = 2; i <= n - 2; i++) {
            if (i % 2 != 0)
                continue;
            for (int j = 1; j <= n - 4; j++) {
                if (i + j > n - 1)
                    continue;
                int k = n - i - j;
                if (k < j + 2)
                    continue;
                answer++;
            }
        }
        System.out.println(answer);
    }
}