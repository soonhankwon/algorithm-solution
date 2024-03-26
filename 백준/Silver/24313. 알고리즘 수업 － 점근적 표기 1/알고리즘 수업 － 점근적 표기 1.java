import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input1 = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int a1 = input1[0]; //7
        int a0 = input1[1]; //7

        int c = Integer.parseInt(br.readLine()); //8
        int n0 = Integer.parseInt(br.readLine()); //1
        boolean isSatisfied = a1 * n0 + a0 <= c * n0 && c >= a1;
        if (isSatisfied) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
        br.close();
    }
}
