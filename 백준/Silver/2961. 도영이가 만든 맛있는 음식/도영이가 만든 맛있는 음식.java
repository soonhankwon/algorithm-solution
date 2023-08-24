import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static List<int[]> data;
    static int n;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        answer = Integer.MAX_VALUE;

        data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            data.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        recursion(0, 1, 0, 0);
        System.out.println(answer);
    }

    private static void recursion(int depth, int s, int b, int use) {
        if (depth == n) {
            if(use == 0) {
                return;
            }
            int result = Math.abs(s - b);
            answer = Math.min(result, answer);
            return;
        }
        recursion(depth + 1, s * data.get(depth)[0], b + data.get(depth)[1], use + 1);
        recursion(depth + 1, s, b, use);
    }
}