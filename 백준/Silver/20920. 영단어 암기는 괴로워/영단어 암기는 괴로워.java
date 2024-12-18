import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < arr[0]; i++) {
            String word = br.readLine();
            if(word.length() >= arr[1]) {
                map.compute(word, (k, v) -> v == null ? 1 : ++v);
            }
        }
        List<String> result = map.keySet().stream()
                .sorted((w1, w2) -> {
                    // 1. 빈도수 내림차순
                    int freqCompare = map.get(w2).compareTo(map.get(w1));
                    if (freqCompare != 0) {
                        return freqCompare;
                    }
                    // 2. 길이 내림차순
                    int lengthCompare = Integer.compare(w2.length(), w1.length());
                    if (lengthCompare != 0) {
                        return lengthCompare;
                    }
                    // 3. 사전순 오름차순
                    return w1.compareTo(w2);
                })
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        result.forEach(item -> sb.append(item).append("\n"));
        System.out.println(sb);
        br.close();
    }
}