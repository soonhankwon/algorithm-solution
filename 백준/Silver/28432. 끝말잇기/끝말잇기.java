import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    // 이후에 중복된 단어를 후보에서 제거해야함
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] arr = new String[n];
        // '?' 인덱스 flag
        int questionIndex = 0;
        // 3가지 케이스가 있음 -> 맨앞 또는 맨뒤에 ?, 그리고 중간에 ?
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            if (input.equals("?")) {
                questionIndex = i;
                continue;
            }
            arr[i] = input;
            set.add(input);
        }

        int m = Integer.parseInt(br.readLine());
        List<String> candidates = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            candidates.add(br.readLine());
        }

        String answer;
        // 예외케이스!
        if (n == 1 || m == 1) {
            answer = candidates.get(0);
            System.out.println(answer);
            return;
        }
        //questionIndex 의 위치로 케이스판별
        if (questionIndex == 0) {
            answer = checkWord(candidates, null, arr[questionIndex + 1]);
            System.out.println(answer);
            return;
        }
        if (questionIndex == arr.length - 1) {
            answer = checkWord(candidates, arr[questionIndex - 1], null);
            System.out.println(answer);
            return;
        }
        answer = checkWord(candidates, arr[questionIndex - 1], arr[questionIndex + 1]);
        System.out.println(answer);
        br.close();
    }

    private static String checkWord(List<String> candidates, String before, String after) {
        if (before == null) {
            return candidates.stream()
                    .filter(candidate -> !set.contains(candidate)
                            && candidate.charAt(candidate.length() - 1) == after.charAt(0))
                    .findFirst()
                    .orElse(null);
        }
        if (after == null) {
            return candidates.stream()
                    .filter(candidate -> !set.contains(candidate)
                            && candidate.charAt(0) == before.charAt(before.length() - 1))
                    .findFirst()
                    .orElse(null);
        }
        return candidates.stream()
                .filter(candidate -> !set.contains(candidate)
                        && candidate.charAt(0) == before.charAt(before.length() - 1)
                        && candidate.charAt(candidate.length() - 1) == after.charAt(0))
                .findFirst()
                .orElse(null);
    }
}
