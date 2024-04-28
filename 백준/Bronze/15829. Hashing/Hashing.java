import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final int MOD = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        long answer = 0;
        long pow = 1;
        for (int i = 0; i < n; i++) {
            answer += (input.charAt(i) - 96) * pow;
            pow = (pow * 31) % MOD;
        }
        System.out.println(answer % MOD);
        br.close();
    }
}
