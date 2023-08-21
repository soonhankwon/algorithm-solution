import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String[]> hints = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            hints.add(br.readLine().split(" "));
        }

        int answer = 0;
        for(int i = 1; i < 10; i++) {
            for(int j = 1; j < 10; j++) {
                for(int k = 1; k < 10; k++) {
                    if(i == j || j == k || k == i) continue;
                    int count = 0;

                    for (String[] hint : hints) {
                        String number = hint[0];
                        int strike = Integer.parseInt(hint[1]);
                        int ball = Integer.parseInt(hint[2]);

                        String[] split = number.split("");

                        int first = Integer.parseInt(split[0]);
                        int second = Integer.parseInt(split[1]);
                        int third = Integer.parseInt(split[2]);

                        int strikeCnt = 0;
                        int ballCnt = 0;

                        if(i == first) {
                            strikeCnt++;
                        }
                        if (j == second) {
                            strikeCnt++;
                        }
                        if (k == third) {
                            strikeCnt++;
                        }

                        if(i == second || i == third) {
                            ballCnt++;
                        }
                        if (j == first || j == third) {
                            ballCnt++;
                        }
                        if (k == first || k == second) {
                            ballCnt++;
                        }

                        if(ball == ballCnt && strike == strikeCnt) count++;
                    }
                    if(count == n)
                        answer++;
                }
            }
        }
        System.out.println(answer);
    }
}