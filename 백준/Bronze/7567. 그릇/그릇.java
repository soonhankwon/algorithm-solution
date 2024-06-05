import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        int cnt = 10;
        char head = chars[0];
        for (int i = 1; i < chars.length; i++) {
            char nowChar = chars[i];
            if (nowChar == head) {
                cnt += 5;
            } else {
                head = nowChar;
                cnt += 10;
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
