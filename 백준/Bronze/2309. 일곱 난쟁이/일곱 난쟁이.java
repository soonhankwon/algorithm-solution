import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<Integer> list, result;
    static StringBuilder sb;
    static boolean isFound;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        result = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        list.sort(Integer::compareTo);
        sb = new StringBuilder();
        recursion(0, 0, 0);
        System.out.println(sb);
        br.close();
    }


    static void recursion(int index, int count, int sum) {
        if (isFound) {
            return;
        }
        if (count == 7) {
            if (sum == 100) {
                result.forEach(i -> sb.append(i).append("\n"));
                isFound = true;
                return;
            }
            return;
        }

        for (int i = index; i < 9; i++) {
            sum += list.get(i);
            result.add(list.get(i));
            recursion(i + 1, count + 1, sum);
            sum -= list.get(i);
            result.remove(list.get(i));
        }
    }
}
