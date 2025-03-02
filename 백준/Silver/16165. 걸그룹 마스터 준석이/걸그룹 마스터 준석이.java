import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = arr[0];
        int m = arr[1];
        Map<String, String> members = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String groupName = br.readLine();
            int memberCnt = Integer.parseInt(br.readLine());
            for (int j = 0; j < memberCnt; j++) {
                String memberName = br.readLine();
                members.put(memberName, groupName);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String target = br.readLine();
            int question = Integer.parseInt(br.readLine());
            if (question == 0) {
                members.entrySet()
                        .stream()
                        .filter(entry -> entry.getValue().equals(target))
                        .forEach(entry -> sb.append(entry.getKey()).append("\n"));
            } else {
                sb.append(members.get(target)).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
