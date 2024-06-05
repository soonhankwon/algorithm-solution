import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                String[] row = br.readLine().split(" ");
                map.compute(row[1], (k, v) -> v == null ? 1 : ++v);
            }
            answer = 1;
            map.values().forEach(v -> answer *= v + 1); //조합
            answer--; // 아무것도 안입은 경우
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
