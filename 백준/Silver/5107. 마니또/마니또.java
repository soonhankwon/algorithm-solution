import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    static Map<String, String> relationMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            // 관계 맵
            relationMap = new HashMap<>();
            // 친구 최대 20명
            String[] userIndexArr = new String[20];
            for (int j = 0; j < n; j++) {
                String[] row = br.readLine().split(" ");
                String user1 = row[0];
                String user2 = row[1];
                userIndexArr[j] = user1;
                relationMap.put(user1, user2);
            }

            int cnt = 0;
            String end;
            for (String start : userIndexArr) {
                end = relationMap.get(start);
                while (true) {
                    end = relationMap.get(end);
                    if (end == null) {
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
