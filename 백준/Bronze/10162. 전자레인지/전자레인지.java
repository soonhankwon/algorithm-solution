import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        br.close();

        // 시간조절 버튼 A B C
        // 5분, 1분, 10초
        // 300초, 60초, 10초
        int a = 0;
        int b = 0;
        int c = 0;
        boolean isMinButtonAvailable = true;
        while (t != 0) {
            // 10으로 나누어 0이 아니라면 false (Fail Fast)
            if (t % 10 != 0) {
                isMinButtonAvailable = false;
                break;
            }
            if (t >= 300) {
                t -= 300;
                a++;
            } else if (t >= 60) {
                t -= 60;
                b++;
            } else {
                t -= 10;
                c++;
            }
        }
        if (isMinButtonAvailable) {
            System.out.printf("%d %d %d", a, b, c);
        } else {
            System.out.println(-1);
        }
    }
}