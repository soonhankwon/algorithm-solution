import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> input1 = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        // 과일의 개수
        Integer fruitsCount = input1.get(0);
        // 현재 스네이크 버드의 길이
        Integer snakeBirdLength = input1.get(1);
        // 오름차순 정렬
        List<Integer> input2 = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());
        br.close();

        for (int i = 0; i < fruitsCount; i++) {
            if (snakeBirdLength >= input2.get(i)) {
                snakeBirdLength++;
            }
        }
        System.out.println(snakeBirdLength);
    }
}