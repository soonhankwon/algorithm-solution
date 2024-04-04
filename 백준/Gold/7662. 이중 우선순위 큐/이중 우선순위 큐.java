import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int j = 0; j < k; j++) {
                String[] inputs = br.readLine().split(" ");
                char operation = inputs[0].charAt(0);
                int value = Integer.parseInt(inputs[1]);

                if (operation == 'I') {
                    map.put(value, map.getOrDefault(value, 0) + 1);
                    continue;
                }
                // Case: Operation 'D'
                if (map.isEmpty()) {
                    continue;
                }
                int num = value == 1 ? map.lastKey() : map.firstKey();
                if (map.put(num, map.get(num) - 1) == 1) {
                    map.remove(num);
                }
            }
            if (map.isEmpty()) {
                System.out.println("EMPTY");
                continue;
            }
            System.out.println(map.lastKey() + " " + map.firstKey());
        }
        br.close();
    }
}
