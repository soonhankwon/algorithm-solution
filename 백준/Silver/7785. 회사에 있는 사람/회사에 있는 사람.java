import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            String teamMate = inputs[0];
            if (set.contains(teamMate)) {
                set.remove(teamMate);
                continue;
            }
            set.add(inputs[0]);
        }
        set.forEach(System.out::println);
        br.close();
    }
}