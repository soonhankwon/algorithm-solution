import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .sorted()
                    .toArray();
            int a = inputs[0];
            int b = inputs[1];
            int c = inputs[2];

            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            sb.append(Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2) ? "right\n" : "wrong\n");
        }
        System.out.println(sb);
        br.close();
    }
}
