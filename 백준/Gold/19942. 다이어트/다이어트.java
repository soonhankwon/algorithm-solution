import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static List<int[]> data;
    static int n;
    static int protein;
    static int fat;
    static int carbohydrate;
    static int vitamin;
    static int answer;
    static int[] selected; // 선택한 식품의 인덱스 저장
    static int[] answerSelected; // 복사할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        answer = Integer.MAX_VALUE;
        int[] standard = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        protein = standard[0];
        fat = standard[1];
        carbohydrate = standard[2];
        vitamin = standard[3];

        data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            data.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        selected = new int[n];
        answerSelected = new int[selected.length];

        recursion(0, 0, 0, 0, 0, 0);

        // 선택한 식품들의 인덱스 출력
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
            for (int i = 0; i < answerSelected.length; i++) {
                if (answerSelected[i] == 1) {
                    System.out.print((i + 1) + " ");
                }
            }
        }
        br.close();
    }

    private static void recursion(int depth, int a, int b, int c, int d, int price) {
        if (a >= protein && b >= fat && c >= carbohydrate && d >= vitamin) {
            if (price < answer) {
                answer = price;
                // 선택한 식품의 인덱스 저장
                System.arraycopy(selected, 0, answerSelected, 0, n);
            }
        }

        if (depth == n) {
            return;
        }
        selected[depth] = 1;

        // 사용한 경우 -> 영양소가 더해진다.
        recursion(depth + 1,
                a + data.get(depth)[0],
                b + data.get(depth)[1],
                c + data.get(depth)[2],
                d + data.get(depth)[3],
                price + data.get(depth)[4]);
        selected[depth] = 0; // 사용한 경우의 선택을 해제

        // 사용안한 경우 -> 넘어간다.
        recursion(depth + 1, a, b, c, d, price);
    }
}