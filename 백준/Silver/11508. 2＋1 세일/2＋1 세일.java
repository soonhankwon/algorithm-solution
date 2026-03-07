import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    /*
     * 해결법: Greedy 알고리즘.
     * 1. 오름차순으로 정렬
     * 2. 배열의 뒤에서부터 탐색(내림차순)
     * 3. 인덱스가 3으로 떨어질 경우 sum에서 제외한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] products = new int[n];
        for (int i = 0; i < n; i++) {
            products[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(products);

        long sum = 0;
        int count = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (count % 3 != 0) {
                sum += products[i];
            }
            count++;
        }
        System.out.println(sum);
        br.close();
    }
}