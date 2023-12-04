import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        // n개 화분
        int n = Integer.parseInt(input[0]);
        // k수분 - 초기
        int k = Integer.parseInt(input[1]);
        // 연속된 a개 화분에 물을 줌
        int a = Integer.parseInt(input[2]);
        // B 만큼씩 수분증가
        int b = Integer.parseInt(input[3]);
        int[] pots = new int[n];
        Arrays.fill(pots, k);

        int index = 0;
        int day = 1;
        boolean flag = true;
        while(flag) {
            for(int i = index; i < index + a; i++) {
                pots[i % n] += b;
            }
            for(int i = 0; i < n; i++) {
                if(--pots[i] == 0) {
                    System.out.println(day);
                    flag = false;
                    break;
                }
            }
            day++;
            index = (index + a) % n;
        }
    }
}