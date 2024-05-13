import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int m = row[0]; //10
            int n = row[1]; //12
            int x = row[2]; //3
            int y = row[3]; //9

            int temp = 0;
            int answer = -1;
            int lcm = m * n / gcd(m, n);
            while (temp * m < lcm) {
                if ((temp * m + x - y) % n == 0) {
                    answer = temp * m + x;
                    break;
                }
                temp++;
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int gcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return gcd(num2, num1 % num2);
    }
}
