import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 지수법칙 a^n+m = a^n * a^m
 * 모듈러 (a * b) mod C = (a modC * b modC) modC
 * ((a % c) * (b % c)) % c
 */
public class Main {

    static long c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        long a = inputs[0];
        long b = inputs[1];
        c = inputs[2];

        System.out.println(executePow(a, b));
        br.close();
    }

    private static long executePow(long a, long exponent) {
        if (exponent == 1) {
            return a % c;
        }

        // a^(지수 / 2)
        long temp = executePow(a, exponent / 2);
        // 지수가 홀수라면 a를 한번 더 곱해주어야 함
        // a^7 = a^3 * a^3 * a
        if (exponent % 2 == 1) {
            return (temp * temp % c) * a % c;
        }
        return temp * temp % c;
    }
}
