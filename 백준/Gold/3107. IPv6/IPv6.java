import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        // "::" 로 된 부분은 "0000"이 연속으로 있는 부분이 압축 된 것!
        // 이 부분을 ":zero:" 이 부분으로 대체해서 나중에 "0000"을 갯수만큼 넣기
        if (str.contains("::")) {
            str = str.replace("::", ":zero:");
        }
        // ipArr 배열에 ":" 를 기준으로 자른 문자열을 넣음
        // "::" 가 맨 앞에 있으면 그 자리는 empty
        List<String> inputs = Arrays.stream(str.split(":"))
                .filter(i -> !i.equals(" "))
                .collect(Collectors.toList());
        List<String> results = new ArrayList<>();

        // 각 자리를 4자리로 만들어 results 에 넣음
        for (String input : inputs) {
            while (input.length() < 4) {
                input = "0" + input;
            }
            results.add(input);
        }

        // 8 자리로 만듬
        String[] answer = new String[8];
        // "0000" 이 들어가야 할 갯수
        int size = results.size();
        int zeroLen = 8 - size + 1;
        int idx = 0;
        for (String s : results) {
            // "zero" 일 때 "0000"을 필요한 갯수 만큼 넣음
            if (s.equals("zero")) {
                while (zeroLen-- > 0) {
                    answer[idx] = "0000";
                    idx++;
                }
            }
            // "0000" 가 아닌 값을 넣음
            else {
                answer[idx] = s;
                idx++;
            }
        }

        StringBuilder sb = new StringBuilder(answer[0]);
        int answerLength = answer.length;
        for (int i = 1; i < answerLength; i++) {
            sb.append(":").append(answer[i]);
        }

        System.out.println(sb);
        br.close();
    }
}