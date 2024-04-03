import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 그림을 그려볼것
        // 6 9 5 7 4
        // 주어진 탐 순서의 반대방향(왼쪽)으로 레이저 신호 발사
        // 1. 자신을 기준으로 왼쪽에 자신보다 높으면서 가까운 탑을 찾아야 함
        // 2. 가장 최신의 이전 탑부터 비교할 수 있어야 함 -> Stack
        // 3. 자신은 좌측 탑의 모든 이력을 알 필요가 없다.
        // 3.1 비교를 수행했던 탑을 최신 탑으로 갱신하고 과거의 탑들을 pop 한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Stack<Pair> stack = new Stack<>();
        //첫번째 탑을 스택에 넣어준다.
        stack.add(new Pair(0, inputs[0])); //id:0 num:6

        int length = inputs.length;
        int[] results = new int[length];
        for (int i = 1; i < length; i++) {
            while (!stack.isEmpty()) {
                // input[i] -> 높이가 9이므로 이전 탑은 체크할 필요가 없다!
                int size = stack.size() - 1;
                if (inputs[i] < stack.get(size).num) {
                    Pair pop = stack.get(size);
                    results[i] = pop.id + 1;
                    break;
                }
                stack.pop();
            }
            stack.add(new Pair(i, inputs[i]));
        }
        StringBuilder sb = new StringBuilder();
        Arrays.stream(results)
                .forEach(result -> sb.append(result).append(" "));
        System.out.println(sb);
        br.close();
    }

    private static class Pair {
        int id;
        int num;

        public Pair(int id, int num) {
            this.id = id;
            this.num = num;
        }
    }
}
