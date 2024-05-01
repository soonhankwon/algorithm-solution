import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int excludedCnt = (int) Math.round(n * 0.15);
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(nums);

        int includedCnt = n - excludedCnt;
        int sum = 0;
        for (int i = excludedCnt; i < includedCnt; i++) {
            sum += nums.get(i);
        }

        int answer = Math.round((float) sum / (includedCnt - excludedCnt));
        System.out.println(answer);
        br.close();
    }
}
