import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {

    private static final Pattern pattern = Pattern.compile("\\(\\)");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        while (pattern.matcher(str).find()) {
            str = removePattern(str);
        }
        System.out.println(str.length());
        br.close();
    }

    private static String removePattern(String str) {
        return str.replaceAll("\\(\\)", "");
    }
}
