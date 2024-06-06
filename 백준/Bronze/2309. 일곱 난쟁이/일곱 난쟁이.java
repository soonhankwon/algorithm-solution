import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static List<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        arr = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(br.readLine());
            sum += num;
            arr.add(num);
        }
        findTwoDwarfAndDelete(sum);
        Collections.sort(arr);
        StringBuilder sb = new StringBuilder();
        arr.forEach(i -> sb.append(i).append("\n"));
        System.out.println(sb);
        br.close();
    }

    private static void findTwoDwarfAndDelete(int sum) {
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                Integer dwarf1 = arr.get(i);
                Integer dwarf2 = arr.get(j);
                if (sum - dwarf1 - dwarf2 == 100) {
                    arr.remove(dwarf1);
                    arr.remove(dwarf2);
                    return;
                }
            }
        }
    }
}
