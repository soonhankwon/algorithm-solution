import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Boolean> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            map.compute(br.readLine().split(" ")[0],
                    (k, v) -> v == null || !v);
        }
        StringBuilder sb = new StringBuilder();
        map.entrySet()
                .stream()
                .filter(Entry::getValue)
                .forEach(e -> sb.append(e.getKey()).append("\n"));
        System.out.println(sb);
        br.close();
    }
}