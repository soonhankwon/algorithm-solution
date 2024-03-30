import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    //듣보잡 -> 두케이스중 중복되는 이름을 찾아라 & 사전순
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        int cnt = 0;
        Map<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n + m; i++) {
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0) + 1);
            if (map.get(key) == 2) {
                cnt++;
            }
        }

        System.out.println(cnt);
        map.keySet().stream()
                .filter(k -> map.get(k) == 2)
                .forEach(System.out::println);
        br.close();
    }
}
