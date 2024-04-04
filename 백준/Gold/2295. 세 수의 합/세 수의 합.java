import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        // x + y + z = k
        // x + y = k - z
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        List<Integer> leftHandSide = new ArrayList<>();
        // x + y
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                leftHandSide.add(arr[i] + arr[j]);
            }
        }
        Arrays.sort(arr);
        Collections.sort(leftHandSide);
        // 정렬이 된 상태이므로 이분탐색 사용 - 인덱스를 거꾸로 탐색
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int rightHandSide = arr[i] - arr[j];

                if (Collections.binarySearch(leftHandSide, rightHandSide) >= 0) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
        br.close();
    }
}
