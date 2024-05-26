import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine()
                .chars()
                .filter(c -> c >= 64 && c <= 90)
                .mapToObj(Character::toString)
                .collect(Collectors.joining());
        System.out.println(str);
        br.close();
    }
}
