import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Fn = F_n-1 + F_n-2
 * 1,000,000,000,000,000,000!
 */
public class Main {

    static final long MOD = 1_000_000_007;
    static final long[][] originMatrix = {{1, 1}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long[][] matrix = {{1, 1}, {1, 0}};

        System.out.println(pow(matrix, n - 1)[0][0]);
        br.close();
    }

    private static long[][] pow(long[][] matrix, long exponent) {
        if (exponent == 1 || exponent == 0) {
            return matrix;
        }

        // 지수를 절반으로 분할(divide) 재귀호출
        long[][] res = pow(matrix, exponent / 2);

        // 하위 재귀에서 얻은 행렬 제곱
        res = multiply(res, res);

        if (exponent % 2 == 1) {
            res = multiply(res, originMatrix);
        }

        return res;
    }

    private static long[][] multiply(long[][] matrix1, long[][] matrix2) {
        long[][] res = new long[2][2];

        res[0][0] = ((matrix1[0][0] * matrix2[0][0]) + (matrix1[0][1] * matrix2[1][0])) % MOD;
        res[0][1] = ((matrix1[0][0] * matrix2[0][1]) + (matrix1[0][1] * matrix2[1][1])) % MOD;
        res[1][0] = ((matrix1[1][0] * matrix2[0][0]) + (matrix1[1][1] * matrix2[1][0])) % MOD;
        res[1][1] = ((matrix1[1][0] * matrix2[0][1]) + (matrix1[1][1] * matrix2[1][1])) % MOD;

        return res;
    }
}
