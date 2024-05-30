import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static final String[] arr = new String[]{
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = data[0];
        int m = data[1];
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = n; i <= m; i++) {
            if (i < 10) {
                map.put(arr[i], i);
                continue;
            }
            int first = i / 10;
            int second = i % 10;
            map.put(arr[first] + " " + arr[second], i);
        }
        StringBuilder sb = new StringBuilder();
        AtomicInteger index = new AtomicInteger();
        map.forEach((k, v) -> {
            sb.append(map.get(k)).append(" ");
            index.getAndIncrement();
            if (index.get() % 10 == 0) {
                sb.append("\n");
            }
        });
        System.out.println(sb);
        br.close();
    }
}
