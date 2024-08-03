import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = arr[0];
        int answer = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] >= max) {
                --max;
                answer += arr[i] - max;
                continue;
            }
            max = arr[i];
        }
        System.out.println(answer);
        br.close();
    }
}