import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * XOR(배타적 논리곱) -> 비트마스킹
 */
public class Main {

    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int index = row[1];
            if (!isMen(row)) {
                swapPalindrome(index - 1);
                continue;
            }
            for (int j = 1; j <= n; j++) {
                if (j % index == 0) {
                    arr[j - 1] = arr[j - 1] ^ 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int e = arr[i - 1];
            if (i % 20 == 0) {
                sb.append(e).append("\n");
                continue;
            }
            sb.append(e).append(" ");
        }
        System.out.println(sb);
        br.close();
    }

    private static void swapPalindrome(int mid) {
        int left = mid - 1;
        int right = mid + 1;
        arr[mid] = arr[mid] ^ 1;
        while (left >= 0 && right < n) {
            if (arr[left] == arr[right]) {
                arr[left] = arr[left] ^ 1;
                arr[right] = arr[right] ^ 1;
                left--;
                right++;
                continue;
            }
            break;
        }
    }

    private static boolean isMen(int[] row) {
        return row[0] == 1;
    }
}
