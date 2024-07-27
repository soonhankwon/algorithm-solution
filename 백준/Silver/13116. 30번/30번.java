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

            int a = row[0];
            int b = row[1];
            if (a < b) {
                while (b - a >= a) {
                    b /= 2;
                }
            } else {
                while (a - b >= b) {
                    a /= 2;
                }
            }

            while (a != b) {
                if (a > b) {
                    a /= 2;
                    if (a == b) {
                        break;
                    }
                    b /= 2;
                } else {
                    b /= 2;
                    if (a == b) {
                        break;
                    }
                    a /= 2;
                }
            }
            sb.append(a * 10).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}