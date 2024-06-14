import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(str1.charAt(i));
            sb.append(str2.charAt(i));
        }

        String completeStr = sb.toString();
        sb.setLength(0);
        while (completeStr.length() != 2) {
            for (int i = 0; i < completeStr.length() - 1; i++) {
                int n1 = Integer.parseInt(String.valueOf(completeStr.charAt(i)));
                int n2 = Integer.parseInt(String.valueOf(completeStr.charAt(i + 1)));
                sb.append((n1 + n2) % 10);
            }
            completeStr = sb.toString();
            if (completeStr.length() > 2) {
                sb.setLength(0);
            }
        }
        System.out.println(sb);
        br.close();
    }
}
