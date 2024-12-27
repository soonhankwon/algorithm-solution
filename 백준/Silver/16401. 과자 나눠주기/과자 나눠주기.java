import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] cookies = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int left = 1;
        int right = cookies[cookies.length - 1];
        int answer = 0;
        while(left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int cookie : cookies) {
                cnt += (cookie / mid);
            }
            if(cnt >= arr[0]) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
        br.close();
    }
}