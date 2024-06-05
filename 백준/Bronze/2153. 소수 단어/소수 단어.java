import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = br.readLine().chars()
                .map(Main::hashFunction)
                .sum();
        System.out.println(isPrimeNumber(sum) ? "It is a prime word." : "It is not a prime word.");
        br.close();
    }

    private static char hashFunction(int c) {
        if (c >= 97 && c <= 122) {
            return (char) (c - 96);
        }
        return (char) (c - 38);
    }

    private static boolean isPrimeNumber(int num) {
        if (num == 2 || num == 3) {
            return true;
        }
        if (num % 2 == 0 || num % 3 == 0) {
            return false;
        }
        for (int i = 5; Math.pow(i, 2) <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
