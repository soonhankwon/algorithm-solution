import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = inputs[0]; // n명
        k = inputs[1]; // k개의 조

        // 조마다 티셔츠를 맞추는 비용은 조에서 가장 키가 큰 원생과 가장 키가 작은 원생의 키 차이!
        // 그리디
        int[] data = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 항상 원생들은 인접해있어야 한다.
        // 인접한 유치원생의 키차이가 최소가 되도록
        int[] diff = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            diff[i] = data[i + 1] - data[i];
        }

        Arrays.sort(diff);
        int answer = 0;
        for (int i = 0; i < (n - 1) - (k - 1); i++) {
            answer += diff[i];
        }

        System.out.println(answer);
        br.close();
    }
}
