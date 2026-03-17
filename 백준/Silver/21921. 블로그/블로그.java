import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * 해결법: Sliding Window
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = inputs[0]; // 블로그를 시작하고 지난 일수
        int x = inputs[1]; // x일(범위)

        int[] visitors = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int p1 = 0;
        int p2 = x - 1;
        // 첫 윈도우의 합
        int sum = 0;
        for(int i = 0; i <= p2; i++) {
            sum += visitors[i];
        }

        int max = sum;
        int count = 1;

        // 윈도우를 한 칸씩 이동하며 다음 합을 구함
        while(p2 < n - 1) {
            sum -= visitors[p1];
            p1++;

            p2++;
            sum += visitors[p2];

            if(sum > max) {
                max = sum;
                count = 1;
            }
            else if(sum == max) {
                count++;
            }
        }

        if(max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max + "\n" + count);
        }
        br.close();
    }
}
