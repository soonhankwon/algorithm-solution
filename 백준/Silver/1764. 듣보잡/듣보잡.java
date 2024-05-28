import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sum();

        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.compute(br.readLine(), (k, v) -> v == null ? 1 : ++v);
        }
        StringBuilder sb = new StringBuilder();
        long count = map.entrySet().stream()
                .filter(e -> e.getValue() == 2)
                .count();
        sb.append(count).append("\n");

        map.entrySet().stream()
                .filter(e -> e.getValue() == 2)
                .forEach(e -> sb.append(e.getKey()).append("\n"));
        System.out.println(sb);
        br.close();
    }
}
