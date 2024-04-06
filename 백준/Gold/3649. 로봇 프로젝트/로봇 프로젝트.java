import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 구멍의 너비 x cm
        // 두 조각의 길이의 합 a + b = x
        // 1억 나노미터 -> 10cm
        // two-pointer 탐색
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null) {
            int x = Integer.parseInt(s) * 10_000_000;
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(arr);

            int start = 0;
            int end = n - 1;
            boolean flag = false;
            while (start < end) {
                int sum = arr[start] + arr[end];
                if (sum == x) {
                    System.out.println("yes " + arr[start] + " " + arr[end]);
                    flag = true;
                    break;
                } else if (sum < x) {
                    start++;
                } else {
                    end--;
                }
            }
            if (!flag) {
                System.out.println("danger");
            }
        }
    }
}
