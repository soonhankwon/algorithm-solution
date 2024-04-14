import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * A와B
 */
public class Main {

    static int n, answer;
    static String s, t;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();

        n = s.length();
        sb = new StringBuilder();
        recursion(t);

        System.out.println(answer);
        br.close();
    }

    private static void recursion(String str) {
        int strLength = str.length();
        if (strLength == n) {
            if (str.equals(s)) {
                answer = 1;
            }
            return;
        }

        if (answer == 0 && str.charAt(strLength - 1) == 'A') {
            recursion(str.substring(0, strLength - 1));
        }

        if (answer == 0 && str.charAt(0) == 'B') {
            sb = new StringBuilder();
            recursion(sb.append(str, 1, strLength).reverse().toString());
        }
    }
}
