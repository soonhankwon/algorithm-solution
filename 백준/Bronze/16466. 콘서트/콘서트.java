import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        Set<Integer> set = Arrays.stream(br.readLine().split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toSet());
        for (int i = 1; i <= 1_000_000; i++) {
            if (!set.contains(i)) {
                System.out.println(i);
                break;
            }
        }
        br.close();
    }
}
