import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    /*
     * 1. y와 높이가 같은 건물이 최소 1개 존재해야 함
     * 2. 최소 1개 존재해야 하는 건물이 최대한 넓은 범위여야 함
     * 3. 고도가 변하는 지점을 모두 체크
     * 3.1 고도가 같다면 그대로, 낮다면 건물 개수에 추가
     */

    // 스카이라인 고도 배열
    static int[] skyLine;
    static int answer, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); //10
        skyLine = new int[50_000];

        // 스카이 라인의 고도가 바뀌는 지점의 좌표 x, y
        for (int i = 0; i < n; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            skyLine[i] = inputs[1]; //y 좌표, 즉 고도 입력
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            // 고도가 낮다면 건물 갯수에 추가
            while (!stack.isEmpty() && stack.peek() > skyLine[i]) {
                answer++;
                stack.pop();
            }

            // 고도가 같다면 continue
            if (!stack.isEmpty() && stack.peek() == skyLine[i]) {
                continue;
            }
            // 스택에 건물고도 push
            stack.push(skyLine[i]);
        }
        System.out.println(answer);
        br.close();
    }
}
