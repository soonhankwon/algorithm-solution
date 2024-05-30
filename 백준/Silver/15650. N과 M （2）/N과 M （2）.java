import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n, m;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = inputs[0];
        m = inputs[1];
        arr = new int[m];
        sb = new StringBuilder();
        recursion(0, 1);
        System.out.println(sb);
        br.close();
    }

    private static void recursion(int depth, int num) {
        if (depth == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = num; i <= n; i++) {
            arr[depth] = i;
            recursion(depth + 1, i + 1);
        }
    }
}
