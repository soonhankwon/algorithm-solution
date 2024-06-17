import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            sb.append("1 2 ".repeat(n / 2));
        } else {
            sb.append("1 2 ".repeat(n / 2)).append("3");
        }
        System.out.println(sb);
        br.close();
    }
}
