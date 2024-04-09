import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 부분수열의 합
 */
public class Main {

    static int n, s, answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = inputs[0]; // 1~20
        s = inputs[1]; //target 1,000,000

        arr = new int[n];
        int[] data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 0; i < n; i++) {
            arr[i] = data[i];
        }
        recursion(0, 0);

        System.out.println(s == 0 ? answer - 1 : answer);
        br.close();
    }

    private static void recursion(int depth, int num) {
        if (depth == n) {
            if (num == s) {
                answer++;
            }
            return;
        }

        recursion(depth + 1, num + arr[depth]);
        recursion(depth + 1, num);
    }
}
