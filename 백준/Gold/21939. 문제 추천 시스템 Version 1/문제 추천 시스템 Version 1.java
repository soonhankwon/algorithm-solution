import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Main {
    static TreeSet<Problem> set;
    static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        set = new TreeSet<>();
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int[] inputs = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int id = inputs[0];
            int difficulty = inputs[1];
            set.add(new Problem(id, difficulty));
            map.put(id, difficulty);
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String[] inputs = br.readLine().split(" ");
            String operation = inputs[0];
            if (operation.equals("recommend")) {
                int query = Integer.parseInt(inputs[1]);
                recommend(query);
                continue;
            }
            if (operation.equals("add")) {
                int id = Integer.parseInt(inputs[1]);
                int difficulty = Integer.parseInt(inputs[2]);
                add(id, difficulty);
                continue;
            }
            // case: solved
            int id = Integer.parseInt(inputs[1]);
            solved(id);
        }
        br.close();
    }

    private static void recommend(int query) {
        //1.x가 1인경우 문제리스트에서 가장 어려운 문제 번호 출력
        //1.1 여러개라면 문제 번호가 큰 것으로 출력
        //2.x가 -1인경우 문제리스트에서 가장 쉬운 문제 번호 출력
        //2.1 여러개라면 문제 번호가 작은 것으로 출력
        if (query == 1) {
            System.out.println(set.last().id);
            return;
        }
        System.out.println(set.first().id);
    }

    private static void add(int id, int difficulty) {
        Problem problem = new Problem(id, difficulty);
        set.add(problem);
        map.put(id, difficulty);
    }

    private static void solved(int id) {
        set.remove(new Problem(id, map.get(id)));
        map.remove(id);
    }

    private static class Problem implements Comparable<Problem> {
        int id;
        int difficulty;

        @Override
        public int compareTo(Problem o) {
            if (this.difficulty - o.difficulty == 0) {
                return this.id - o.id;
            }
            return this.difficulty - o.difficulty;
        }

        public Problem(int id, int difficulty) {
            this.id = id;
            this.difficulty = difficulty;
        }
    }
}
