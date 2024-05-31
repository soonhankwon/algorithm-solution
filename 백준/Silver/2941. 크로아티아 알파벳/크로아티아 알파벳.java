import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> set = new HashSet<>(
                Set.of("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=")
        );

        String str = br.readLine();
        int length = str.length();
        int cnt = 0, i = 0, dzCnt = 0;
        while (i < length - 1) {
            String subStr = str.substring(i, i + 2);
            if (subStr.equals("dz") && i < length - 2) {
                subStr = str.substring(i, i + 3);
            }
            if (set.contains(subStr)) {
                if (subStr.equals("dz=")) {
                    dzCnt++;
                } else {
                    cnt++;
                }
                i += 2;
                continue;
            }
            i++;
        }
        System.out.println((length - ((cnt * 2) + (dzCnt * 3))) + (cnt + dzCnt));
        br.close();
    }
}
