import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // coordinate Compression
        // 압축된 원소값의 순위를 매김 -> 같은 값의 원소는 순위가 똑같다.
        int[] originInputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        // 중복이 제거된 정렬 배열을 만듬(압축)
        int[] sortedInputs = Arrays.stream(originInputs)
                .distinct()
                .sorted()
                .toArray();
        
        //각 좌표의 순위를 저장
        Map<Integer, Integer> map = new HashMap<>();
        int length = sortedInputs.length;
        for (int i = 0; i < length; i++) {
            map.put(sortedInputs[i], i);
        }

        StringBuilder sb = new StringBuilder();
        for (int input : originInputs) {
            sb.append(map.get(input)).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}
