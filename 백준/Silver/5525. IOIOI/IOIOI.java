import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        char[] chars = br.readLine().toCharArray();
        // 크기 m의 배열
        int[] arr = new int[m];
        int cnt = 0;
        for (int i = 1; i < m - 1; i++) {
            if (chars[i] == 'O' && chars[i + 1] == 'I') {
                arr[i + 1] = arr[i - 1] + 1;
                if (arr[i + 1] >= n && chars[i - 2 * n + 1] == 'I') {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
