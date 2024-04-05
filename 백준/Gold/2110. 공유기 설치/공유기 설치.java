import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = inputs[0];
        int c = inputs[1];

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        
        int left = 1;
        int right = arr[n - 1] - arr[0];
        int answer = 0;

        int distance;
        while (left <= right) {
            int mid = (left + right) / 2;
            int start = arr[0];
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                distance = arr[i] - start;
                if (distance >= mid) {
                    cnt++;
                    start = arr[i];
                }
            }
            if (cnt >= c) {
                answer = mid;
                left = mid + 1;
                continue;
            }
            right = mid - 1;
        }
        System.out.println(answer);
        br.close();
    }
}
