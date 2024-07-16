import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, Long> map = Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.groupingBy(Integer::valueOf, TreeMap::new, Collectors.counting()));

        int size = map.size();
        StringBuilder sb = new StringBuilder();
        if (size == 1) {
            sb.append(10_000 + (map.firstKey() * 1_000));
        } else if (size == 2) {
            map.forEach((k, v) -> {
                if (v == 2) {
                    sb.append(1_000 + (k * 100));
                }
            });
        } else {
            sb.append(map.lastKey() * 100);
        }
        System.out.println(sb);
        br.close();
    }
}
