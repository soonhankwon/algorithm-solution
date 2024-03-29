import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 만약 S의 모든 소수인 약수(소인수)가 1_000_000 보다 크다면 적절한 패스워드다.
        // 100만보다 작고 2이상의 약수를 가지고 있다면 부적절한 비밀번호 -> 2~100만으로 나눴을때 나머지가 0이라면 부적절하다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            long password = Long.parseLong(br.readLine());
            for (int j = 2; j <= 1_000_000; j++) {
                if (password % j == 0) {
                    sb.append("NO" + "\n");
                    break;
                }
                if (j == 1_000_000) {
                    sb.append("YES" + "\n");
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}
