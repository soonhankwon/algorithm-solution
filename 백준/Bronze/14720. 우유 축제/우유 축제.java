import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] shops = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int expectedShop = 0, cnt = 0;
        for (int shop : shops) {
            if (shop == expectedShop) {
                cnt++;
                expectedShop = (expectedShop + 1) % 3;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
