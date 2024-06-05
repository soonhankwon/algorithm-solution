import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            set.add(str);
        }

        for (String str : set) {
            StringBuilder sb = new StringBuilder(str);
            String reversedStr = sb.reverse().toString();
            if (set.contains(reversedStr)) {
                System.out.println(convertStrFormat(str));
                break;
            }
        }
        br.close();
    }

    private static String convertStrFormat(String str) {
        return str.length() + " " + str.charAt(str.length() / 2);
    }
}
