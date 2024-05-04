import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    static List<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] data = br.readLine().split(" ");
            String operation = data[0];
            if (operation.equals("add")) {
                int value = Integer.parseInt(data[1]);
                add(value);
                continue;
            }
            if (operation.equals("remove")) {
                int value = Integer.parseInt(data[1]);
                remove(value);
                continue;
            }
            if (operation.equals("check")) {
                int value = Integer.parseInt(data[1]);
                sb.append(check(value)).append("\n");
                continue;
            }
            if (operation.equals("toggle")) {
                int value = Integer.parseInt(data[1]);
                toggle(value);
                continue;
            }
            if (operation.equals("all")) {
                all();
                continue;
            }
            empty();
        }
        System.out.println(sb);
        br.close();
    }

    private static void add(int x) {
        arr.add(x);
    }

    private static void remove(int x) {
        if (arr.contains(x)) {
            arr.remove((Integer) x);
        }
    }

    private static int check(int x) {
        return arr.contains(x) ? 1 : 0;
    }

    private static void toggle(int x) {
        if (arr.contains(x)) {
            arr.remove((Integer) x);
            return;
        }
        arr.add(x);
    }

    private static void all() {
        arr.clear();
        IntStream.range(1, 21).forEach(arr::add);
    }

    private static void empty() {
        arr.clear();
    }
}
