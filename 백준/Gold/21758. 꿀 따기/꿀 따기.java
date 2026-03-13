import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * 해결법: Greedy + Prefix Sum
         * 두 꿀벌이 최대한 많은 좌표를 지나야함
         * 중간에서 출발하면 많은 좌표를 지날 수 없음
         * 3가지 케이스
         * 1. 벌,벌 - 벌통(오른쪽 끝)
         * 2. 벌통(왼쪽 끝) - 벌,벌
         * 3. 벌 - 벌통(중간) - 벌
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] honeys = new int[n + 1]; // 인덱스 1부터 시작
        int[] prefixSum = new int [n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            honeys[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + honeys[i];
        }

        int max = 0;
        // 1. 벌 - 벌 - 벌통
        for(int i = 2; i <= n - 1; i++) {
            int case1 = (prefixSum[n] - honeys[1] - honeys[i]) + (prefixSum[n] - prefixSum[i]);
            max = Math.max(max, case1);
        }

        // 2. 벌통 - 벌 - 벌
        for (int i = 2; i <= n - 1; i++) {
            int case2 = (prefixSum[n] - honeys[n] - honeys[i]) + prefixSum[i - 1];
            max = Math.max(max, case2);
        }

        // 3. 벌 - 벌통 - 벌(1번, n번을 제외한 모든 꿀을 채취)
        for (int i = 2; i <= n - 1; i++) {
            int case3 = prefixSum[n] - honeys[1] - honeys[n] + honeys[i];
            max = Math.max(max, case3);
        }

        System.out.println(max);
        br.close();
    }
}
