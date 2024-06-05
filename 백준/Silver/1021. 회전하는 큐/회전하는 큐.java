import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class Main {

    static LinkedList<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = inputs[0];
        int m = inputs[1];

        deque = new LinkedList<>();
        IntStream.rangeClosed(1, n).forEach(deque::add);

        int[] row = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int targetIndex = deque.indexOf(row[i]);
            int halfIndex;
            int size = deque.size();
            halfIndex = size % 2 == 0 ? size / 2 - 1 : size / 2;
            if (targetIndex <= halfIndex) {
                for (int j = 0; j < targetIndex; j++) {
                    leftShiftOperation();
                    cnt++;
                }
            } else {
                for (int j = 0; j < size - targetIndex; j++) {
                    rightShiftOperation();
                    cnt++;
                }
            }
            deque.pop();
        }
        System.out.println(cnt);
        br.close();
    }

    private static void leftShiftOperation() {
        Integer poll = deque.pollFirst();
        deque.addLast(poll);
    }

    private static void rightShiftOperation() {
        Integer poll = deque.pollLast();
        deque.addFirst(poll);
    }
}
