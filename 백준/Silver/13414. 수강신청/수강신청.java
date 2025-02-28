import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int k = arr[0];
        int l = arr[1];
        int timeStamp = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < l; i++) {
            String studentNumber = br.readLine();
            map.put(studentNumber, ++timeStamp);
        }
        StringBuilder sb = new StringBuilder();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(k)
                .forEach(v -> sb.append(v.getKey()).append("\n"));
        System.out.println(sb);
        br.close();
    }
}