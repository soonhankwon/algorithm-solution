import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static List<int[]> interviews = new ArrayList<>();
    static int answer;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            interviews.add(Arrays.stream(br.readLine()
                            .split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray());
        }
        answer = Integer.MIN_VALUE;
        recursion(0, 0);
        System.out.println(answer);
    }

    private static void recursion(int depth, int price) {
        if (depth == n) {
            answer = Math.max(answer, price);
            return;
        } else if (depth > n) {
            return;
        }

        // 상담을 한다면
        recursion(depth + interviews.get(depth)[0],
                price + interviews.get(depth)[1]);

        // 상담을 하지 않는다면
        recursion(depth + 1, price);
    }
}