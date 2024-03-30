import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        //pn 만들기
        String pn = "IOI" + "OI".repeat(n - 1);
        Pattern pattern = Pattern.compile(pn);

        String s = br.readLine();
        int start = 0;
        int end = pn.length() - 1;
        int cnt = 0;
        for (int i = 0; i < 1_000_000; i++) {
            if (end == s.length()) {
                break;
            }
            String substring = s.substring(start, end + 1);
            if (pattern.matcher(substring).matches()) {
                cnt++;
            }
            start++;
            end++;
        }
        System.out.println(cnt);
        br.close();
    }
}
