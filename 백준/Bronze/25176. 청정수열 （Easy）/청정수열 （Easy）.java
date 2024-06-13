import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 두 개 i사이 수가 최대한 없어야 함 -> 점수 최소
 * 점수가 최소인 청정수열 eg) 1122, 112233 -> i가 붙어있어야 함
 * 결국 12, 123, 321 등 N이 주어졌을때 만들수 있는 순열의 조합임
 * eg) n = 3 -> 3 * 2 * 1(3!)
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(factorial(n));
        br.close();
    }

    private static int factorial(int num) {
        if (num == 1) {
            return 1;
        }
        return num * (factorial(num - 1));
    }
}
