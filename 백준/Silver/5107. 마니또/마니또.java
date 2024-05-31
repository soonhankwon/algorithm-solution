import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {

    static Map<String, String> relationMap;
    static int n, cnt;
    static String[] userIndexArr = new String[20];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            // 관계 맵
            relationMap = new HashMap<>();
            // 친구 최대 20명
            for (int j = 0; j < n; j++) {
                String[] row = br.readLine().split(" ");
                String user1 = row[0];
                String user2 = row[1];
                userIndexArr[j] = user1;
                relationMap.put(user1, user2);
            }

            cnt = 0;
            String end;
            for (String start : userIndexArr) {
                end = relationMap.get(start);
                while (true) {
                    end = relationMap.get(end);
                    if (Objects.isNull(end)) {
                        break;
                    } else if (end.equals(start)) {
                        cnt++;
                        relationMap.keySet().remove(end);
                        break;
                    }
                }
            }
            sb.append(i).append(" ").append(cnt).append("\n");
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
        }
        System.out.println(sb);
        br.close();
    }
}
