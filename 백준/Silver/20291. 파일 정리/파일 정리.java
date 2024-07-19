import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            map.compute(str.substring(str.lastIndexOf('.') + 1),
                    (k, v) -> v == null ? 1 : ++v);
        }
        StringBuilder sb = new StringBuilder();
        map.forEach((k, v) -> sb.append(k).append(" ").append(v).append("\n"));
        System.out.println(sb);
    }
}