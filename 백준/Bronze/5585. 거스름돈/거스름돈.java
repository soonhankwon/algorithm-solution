import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 1000 - Integer.parseInt(br.readLine());
        //greedy - 눈앞의 최적의 해
        int count = 0;
        int index = 0;
        //500, 100, 50, 10, 5, 1yen
        int[] money = {500, 100, 50, 10, 5, 1};
        while (n != 0) {
            if (n % money[index] >= 0) {
                count += n / money[index];
                n = n % money[index];
            }
            index++;
        }
        System.out.println(count);
    }
}