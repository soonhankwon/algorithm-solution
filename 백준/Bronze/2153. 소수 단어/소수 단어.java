import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<Integer, Integer> hashFunction = c -> {
            if (c >= 97 && c <= 122) {
                return c - 96;
            }
            return c - 38;
        };
        int sum = br.readLine().chars()
                .map(hashFunction::apply)
                .sum();
        System.out.println(isPrimeNumber(sum) ? "It is a prime word." : "It is not a prime word.");
        br.close();
    }

    // 에라스토텔레스 체
    private static boolean isPrimeNumber(int num) {
        if (num == 2 || num == 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (int i = 5; i <= Math.sqrt(num); i++) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
