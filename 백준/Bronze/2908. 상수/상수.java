import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // StringBuilder reverse
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());
        String reversedStr = sb.reverse().toString();

        String[] inputs = reversedStr.split(" ");
        int a = Integer.parseInt(inputs[0]);
        int b = Integer.parseInt(inputs[1]);

        if (a > b) {
            System.out.println(a);
            return;
        }
        System.out.println(b);
    }
}
