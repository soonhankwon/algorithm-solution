import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Main {

    static TreeMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] row = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < 3; i++) {
            int num = row[i];
            map.compute(num, (k, v) -> (v == null) ? 1 : ++v);
        }
        computeResult();
        br.close();
    }

    private static void computeResult() {
        int size = map.size();
        if (size == 1) {
            int num = map.firstKey();
            System.out.println(10_000 + (num * 1_000));
            return;
        }
        if (size == 2) {
            map.entrySet()
                    .stream()
                    .filter(i -> i.getValue() == 2)
                    .findFirst()
                    .ifPresent(i -> {
                        System.out.println(1_000 + (i.getKey() * 100));
                    });
            return;
        }
        int num = map.firstKey();
        System.out.println(num * 100);
    }
}