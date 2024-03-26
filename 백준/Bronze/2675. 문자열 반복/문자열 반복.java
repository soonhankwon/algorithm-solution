import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String[] inputs = br.readLine().split(" ");
            int r = Integer.parseInt(inputs[0]);
            String s = inputs[1];
            int sLength = s.length();
            for (int j = 0; j < sLength; j++) {
                sb.append(String.valueOf(s.charAt(j)).repeat(Math.max(0, r)));
            }
            if (i < t - 1) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }
}
