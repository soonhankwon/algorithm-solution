import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        long count = Arrays.stream(str.strip().split(" "))
                .filter(s -> !s.isEmpty())
                .count();
        System.out.println(count);
        br.close();
    }
}
