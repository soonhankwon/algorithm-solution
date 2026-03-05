import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * Input:
         * 4 3
         * 1 2 3 4
         * Output:
         * 2
         * 해결법: 새 테이프를 붙일 때마다 그 테이프가 어디까지 덮을 수 있는지 결정
         * 덮을 수 있는 최대 좌표: 시작 지점 - 0.5 + L
         * 다음 구멍이 최대 좌표 안에 들어오는지 확인
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int l = inputs[1]; // 테이프 길이

        int[] breakPoints = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int tapeCount = 0;
        double coverRange = 0; // 현재 테이프가 커버하는 오른쪽 끝 좌표
        for (int point : breakPoints) {
            if(point > coverRange) {
                tapeCount++;
                coverRange = point - 0.5 + l;
            }
        }
        System.out.println(tapeCount);
        br.close();
    }
}
