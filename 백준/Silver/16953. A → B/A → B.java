import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static long a, b, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        a = inputs[0];
        b = inputs[1];

        answer = Long.MAX_VALUE;
        recursion(0, a, 0);
        if (answer == Long.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
        br.close();
    }

    private static void recursion(long depth, long num, long len) {
        if (num >= b) {
            if (num == b) {
                answer = Math.min(answer, len + 1);
            }
            return;
        }

        recursion(depth + 1, num * 2, len + 1);
        recursion(depth + 1, num * 10 + 1, len + 1);
    }
}
