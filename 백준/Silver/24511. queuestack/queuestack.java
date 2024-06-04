import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

    static int index = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        Deque<Integer> deque = new ArrayDeque<>();
        int[] data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(i -> {
                    if (data[index] == 0) {
                        deque.addLast(i);
                    }
                    index++;
                });

        br.readLine();
        StringBuilder sb = new StringBuilder();
        Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(i -> {
                    deque.addFirst(i);
                    sb.append(deque.pollLast()).append(" ");
                });
        System.out.println(sb);
        br.close();
    }
}
