import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            String fruit = inputs[0];
            int value = Integer.parseInt(inputs[1]);
            map.put(fruit, map.getOrDefault(fruit, 0) + value);

        }

        String answer = "NO";
        for (String key : map.keySet()) {
            if (map.get(key) == 5) {
                answer = "YES";
                break;
            }
        }
        System.out.println(answer);
        br.close();
    }
}
