import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

/*
 * 유니온-파인드
 */
public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine()); // 게이트 수
        int p = Integer.parseInt(br.readLine()); // 비행기 수

        arr = IntStream.rangeClosed(0, g)
                .toArray();
        
        // g번 비행기 -> g번 이하 게이트 도킹가능
        // g번 비행기를 g번 게이트에 도킹하는 것이 베스트
        // g번 게이트에 도킹할 수 없다면 -> g-1번 게이트에 차선책으로 도킹
        // -> 차선책 g-2번 ~ 0번 탐색
        // 차선책 0번: 도킹 불가능
        // 차선책 탐색 방법 -> 유니온 파인드
        int answer = 0;
        for (int i = 0; i < p; i++) {
            int gate = Integer.parseInt(br.readLine());
            int possibleGate = find(gate);
            if (possibleGate == 0) {
                break;
            }
            answer++;
            union(possibleGate, possibleGate - 1);
        }
        System.out.println(answer);
        br.close();
    }

    private static int find(int num) {
        if (num == arr[num]) {
            return num;
        }
        return arr[num] = find(arr[num]);
    }

    private static void union(int num1, int num2) {
        num1 = find(num1);
        num2 = find(num2);
        if (num1 != num2) {
            arr[num1] = num2;
        }
    }
}