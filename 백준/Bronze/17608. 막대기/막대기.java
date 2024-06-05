import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int nowLine = arr[n - 1];
        int cnt = 0;
        for (int i = n - 2; i >= 0; i--) {
            int nowTower = arr[i];
            if (nowTower <= nowLine) {
                continue;
            }
            cnt++;
            nowLine = nowTower;
        }
        System.out.println(cnt + 1);
        br.close();
    }
}
