import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 이분 탐색 최적화 -> 문자열을 자를 때
 */
public class Main {

    static String[] arr;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        n = inputs[0];
        m = inputs[1];
        arr = new String[m];

        br.readLine();
        for (int i = 0; i < n - 1; i++) {
            String row = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[j] = i == 0 ? String.valueOf(row.charAt(j)) : arr[j] + row.charAt(j);
            }
        }

        int left = 0;
        int right = arr[0].length();
        int maxUniqueIndex = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isAllStringUnique(mid)) {
                maxUniqueIndex = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(maxUniqueIndex);
        br.close();
    }

    private static boolean isAllStringUnique(int index) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            String str = arr[i].substring(index);
            if (!set.add(str)) {
                return false;
            }
        }
        return true;
    }
}
