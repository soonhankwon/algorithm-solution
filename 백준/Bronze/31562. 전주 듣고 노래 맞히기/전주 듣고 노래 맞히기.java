import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = inputs[0];
        int m = inputs[1];
        Map<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split(" ");
            sb.append(row[2]).append(" ").append(row[3]).append(" ").append(row[4]);
            map.compute(sb.toString(), (k, v) -> v == null ? row[1] : "?");
            sb.setLength(0);
        }
        for (int i = 0; i < m; i++) {
            sb.append(map.getOrDefault(br.readLine(), "!"));
            if (i < m - 1) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
