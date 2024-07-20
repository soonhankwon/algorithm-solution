import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final Pattern pattern = Pattern.compile("(<[^>]+>)|([a-z0-9]+)|( )");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Matcher matcher = pattern.matcher(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                sb.append(matcher.group(1));
            } else if (matcher.group(2) != null) {
                sb.append(new StringBuilder(matcher.group(2)).reverse());
            } else if (matcher.group(3) != null) {
                sb.append(matcher.group(3));
            }
        }
        System.out.println(sb);
        br.close();
    }
}
