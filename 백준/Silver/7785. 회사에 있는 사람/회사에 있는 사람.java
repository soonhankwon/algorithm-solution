import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            map.compute(br.readLine().split(" ")[0],
                    (k, v) -> v == null ? 1 : ++v);
        }
        StringBuilder sb = new StringBuilder();
        map.entrySet()
                .stream()
                .filter(e -> e.getValue() % 2 == 1)
                .forEach(e -> sb.append(e.getKey()).append("\n"));
        System.out.println(sb);
        br.close();
    }
}