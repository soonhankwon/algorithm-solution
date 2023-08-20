import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int a, b, c, d, e, f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        a = Integer.parseInt(inputs[0]);
        b = Integer.parseInt(inputs[1]);
        c = Integer.parseInt(inputs[2]);
        d = Integer.parseInt(inputs[3]);
        e = Integer.parseInt(inputs[4]);
        f = Integer.parseInt(inputs[5]);

        StringBuilder sb = new StringBuilder();
        for(int x = -999; x < 1_000; x++) {
            for (int y = -999; y < 1_000; y++) {
                if(a * x + b * y == c && d * x + e * y == f) {
                    sb.append(x).append(" ").append(y);
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}