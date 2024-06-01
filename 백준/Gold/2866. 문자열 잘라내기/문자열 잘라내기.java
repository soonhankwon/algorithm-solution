import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = inputs[0];
        int m = inputs[1];

        String[] arr = new String[m];
        br.readLine();
        for (int i = 0; i < n - 1; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[j] = i == 0 ? String.valueOf(row.charAt(j)) : arr[j] + row.charAt(j);
            }
        }
        int cnt = 0;
        Set<String> set = new HashSet<>();
        int maxLen = arr[0].length();
        for (int index = 0; index < maxLen; index++) {
            for (int i = 0; i < m; i++) {
                String str = arr[i].substring(index);
                set.add(str);
            }
            if (set.size() != m) {
                break;
            } else {
                cnt++;
                set.clear();
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
