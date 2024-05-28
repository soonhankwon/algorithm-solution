import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.compute(br.readLine().split("\\.")[1],
                    (k, v) -> v == null ? 1 : ++v);
        }
        StringBuilder sb = new StringBuilder();
        map.forEach((key, value) -> sb.append(key).append(" ").append(value).append("\n"));
        System.out.println(sb);
        br.close();
    }
}
