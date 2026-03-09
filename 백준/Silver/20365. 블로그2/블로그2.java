import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * 해결법: Greedy
         * 1. 가장 많이 나온 색깔로 한 번에 다 칠함
         * 2. 나머지 색깔 그룹 개수만큼 추가로 칠함
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();

        int blueGroup = 0;
        int redGroup = 0;

        if(chars[0] == 'B') {
            blueGroup++;
        } else {
            redGroup++;
        }

        for(int i = 1; i < n; i++) {
            if(chars[i] != chars[i - 1]) {
                if(chars[i] == 'B') {
                    blueGroup++;
                } else {
                    redGroup++;
                }
            }
        }
        // 전체를 한색으로 칠하고 + 나머지 색깔 그룹 개수만큼 칠함
        System.out.println(Math.min(blueGroup, redGroup) + 1);
        br.close();
    }
}