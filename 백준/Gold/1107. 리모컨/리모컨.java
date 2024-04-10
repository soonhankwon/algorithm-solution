import java.io.IOException;
import java.util.Scanner;

/*
 * 리모컨
 * 완전탐색
 * 지금 보고 있는 채널은 100번
 */
public class Main {

    static int n, m, answer;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        boolean[] brokenBtn = new boolean[10];
        for (int i = 0; i < m; i++) {
            int d = sc.nextInt();
            brokenBtn[d] = true;
        }

        answer = Math.abs(n - 100);
        //999,999 를 누르는 경우 포함
        for (int i = 0; i <= 999_999; i++) {
            String channel = String.valueOf(i); //996
            int length = channel.length(); //3

            boolean isBroken = false;
            for (int j = 0; j < length; j++) {
                // 버튼이 고장난 경우 break
                if (brokenBtn[channel.charAt(j) - '0']) {
                    isBroken = true;
                    break;
                }
            }
            // 해당버튼을 누른후 +1, -1로 이동하는 경우를 계산
            if (!isBroken) {
                // i를 누른 후 n까지 이동하는 횟수(n - i)    (996 - 999) + 버튼누른수(eg 999 -> 3)
                answer = Math.min(answer, Math.abs(n - i) + length);
            }
        }
        System.out.println(answer);
        sc.close();
    }
}
