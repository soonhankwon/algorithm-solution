import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] inputs = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long a = inputs[0];
        long b = inputs[1];

        System.out.println(gcd(a, b));
        System.out.println(lcm(a, b));
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    private static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}