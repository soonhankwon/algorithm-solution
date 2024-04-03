import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1 2 3 4 원형이다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        /* 풍선안의 종이는 음수, 양수 -> 움직이는 방향이 두 가지이다.
         * 양수 -> 해당 숫자만큼 움직이면서 앞에 있는 값을 뒤로 갱신
         * 음수 -> 반대방향으로 뒤에 있는 값을 앞으로 갱신
         */

        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 첫번째 오퍼레이션
        StringBuilder sb = new StringBuilder();
        sb.append("1 ");

        // 양방향에서 모두 삽입과 삭제가 가능하다.
        Deque<Pair> deque = new ArrayDeque<>();
        for (int i = 1; i < n; i++) {
            deque.add(new Pair(i + 1, inputs[i]));
        }

        int dirValue = inputs[0];
        while (!deque.isEmpty()) {
            // 양수가 나왔을때 -> 앞에 있는 요소를 모두 뒤로 보내는 경우
            if (dirValue > 0) {
                for (int i = 1; i < dirValue; i++) {
                    deque.add(deque.poll());
                }

                Pair first = deque.poll();
                assert first != null;

                dirValue = first.num;
                sb.append(first.id).append(" ");
                continue;
            }
            // 음수가 나왔을때 -> 뒤에 있는 요소들을 모두 앞으로 보내는 경우
            for (int i = 1; i < -dirValue; i++) {
                deque.addFirst(deque.pollLast());
            }

            Pair last = deque.pollLast();
            assert last != null;

            dirValue = last.num;
            sb.append(last.id).append(" ");
        }
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
