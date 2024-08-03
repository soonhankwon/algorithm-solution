import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 8;
        int index = 0;
        int power = 1;
        while (power < n) {
            power <<= 1;
            index++;
        }
        cnt += index + (power == n ? 2 : 1);
        System.out.println(cnt);
        br.close();
    }
}