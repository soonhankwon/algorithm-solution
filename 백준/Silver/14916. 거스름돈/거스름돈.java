import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        if (n == 1 || n == 3) {
            System.out.println(-1);
        } else if (n % 5 == 0) {
            System.out.println(n / 5);
        } else if (n % 5 == 1) {
            System.out.println((n / 5) - 1 + 3);
        } else if (n % 5 == 2) {
            System.out.println((n / 5) + 1);
        } else if (n % 5 == 3) {
            System.out.println((n / 5) - 1 + 4);
        } else if (n % 5 == 4) {
            System.out.println((n / 5) + 2);
        } else if (n % 2 == 1) {
            System.out.println((n / 2) - 1 + 1);
        } else if (n % 2 == 0) {
            System.out.println(n / 2);
        }
    }
}