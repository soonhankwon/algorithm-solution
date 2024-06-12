import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// nPr = n!/(n-r)!
// nCr = n! / r!(n-r)!

// 8C5 -> 8! / 5! * 3!
// 9C5 -> 9! / 5! * 4!
// 10C5 -> 10! / 5! * 5!
// 10 * 9 * 8 * 7 * 6 / 5!
// 11C5 -> 11! / 5! * 6!
// 11 * 10 * 9 * 8 * 7 / 5!
// 12C5 -> 12! / 5! * 7!
// 12 * 11 * 10 * 9 * 8 / 5!
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n < 10) {
            System.out.println(factorial(n) / (factorial(5) * factorial(n - 5)));
        } else {
            long combination = partialFactorial(n, 0) / factorial(5);
            System.out.println(combination);
        }
        br.close();
    }

    private static int factorial(int num) {
        int res = 1;
        for (int i = 1; i <= num; i++) {
            res *= i;
        }
        return res;
    }

    private static long partialFactorial(int num, int depth) {
        if (depth == 5) {
            return 1;
        }
        return num * partialFactorial(num - 1, depth + 1);
    }
}
