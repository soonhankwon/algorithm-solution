import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    /*
     * 해결법: Greedy 알고리즘.
     * 1. 내림차순으로 정렬
     * 2. 인덱스가 3으로 떨어질 경우 sum에서 제외한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> products = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            products.add(Integer.valueOf(br.readLine()));
        }
        products.sort((a, b) -> b - a);
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0) continue;
            Integer product = products.get(i - 1);
            sum += product;
        }
        System.out.println(sum);
        br.close();
    }
}
