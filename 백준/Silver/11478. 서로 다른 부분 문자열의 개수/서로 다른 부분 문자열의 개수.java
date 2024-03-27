import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        Set<String> set = new HashSet<>();
        int length = input.length();
        int startIndex = 0;
        int endIndex = 0;
        int windowSize = 1;
        for (int i = 0; i < length + 1; i++) {
            for (int j = 0; j < length + 1; j++) {
                if (endIndex + windowSize > length) {
                    //index 초기화
                    startIndex = 0;
                    endIndex = 0;
                    windowSize++;
                    break;
                }
                String str = input.substring(startIndex, endIndex + windowSize);
                set.add(str);
                startIndex++;
                endIndex++;
            }
        }
        System.out.println(set.size());
        br.close();
    }
}
