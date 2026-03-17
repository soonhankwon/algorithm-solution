import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * 해결법: 투포인터
         * 1. 각 정렬된 입력배열의 왼쪽에서 포인터를 이동시키면서 StringBuilder에 append
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().trim().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = inputs[0];
        int m = inputs[1];
        int[] a = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringBuilder sb = new StringBuilder();
        int p1 = 0;
        int p2 = 0;
        while(p1 < n && p2 < m) {
            if(a[p1] <= b[p2]) {
                sb.append(a[p1++]).append(" ");
            } else {
                sb.append(b[p2++]).append(" ");
            }
        }

        // 남은 요소들 append
        while(p1 < n) {
            sb.append(a[p1++]).append(" ");
        }
        while(p2 < m) {
            sb.append(b[p2++]).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}
