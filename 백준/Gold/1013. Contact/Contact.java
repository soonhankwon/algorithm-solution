import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {

    //패턴을 여러 번 사용하는 경우 한 번 컴파일한 후 재사용
    static final Pattern pattern = Pattern.compile("(100+1+|01)+");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            if (!pattern.matcher(br.readLine()).matches()) {
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
        }
    }
}
