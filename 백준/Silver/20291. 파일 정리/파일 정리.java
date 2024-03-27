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
            String[] inputs = br.readLine().split("\\.");
            String extension = inputs[1];
            map.put(extension, map.getOrDefault(extension, 0) + 1);
        }

        map.keySet()
                .stream()
                .sorted()
                .forEach(i -> {
                    System.out.println(i + " " + map.get(i));
                });
        br.close();
    }
}
