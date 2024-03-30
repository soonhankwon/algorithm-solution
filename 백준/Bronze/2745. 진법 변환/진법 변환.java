import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        String n = inputs[0]; //ZZZZZ
        int b = Integer.parseInt(inputs[1]); //36

        // A- Z => 숫자로 => c - 55
        // 10 (2진법) -> 1 * 2^1 + 0 * 2^0
        int answer = 0;
        int length = n.length(); //5
        for (int i = 0; i < length; i++) {
            char c = n.charAt(i);
            int num;
            if (c >= 'A' && c <= 'Z') {
                num = c - 55;
            } else {
                num = c - '0';
            }
            //Z = 35
            answer += (int) (num * (Math.pow(b, length - i - 1)));
        }

        System.out.println(answer);
        br.close();
    }
}
