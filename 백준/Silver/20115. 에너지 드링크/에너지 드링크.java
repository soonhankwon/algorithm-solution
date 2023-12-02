import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 페인이 가지고 있는 에너지 드링크의 수 n
        int n = Integer.parseInt(br.readLine());
        // 오름차순 정렬
        List<Long> input1 = Arrays.stream(br.readLine().split(" "))
                .map(Long::parseLong)
                .sorted()
                .collect(Collectors.toList());
        br.close();

        // 가장 큰 에너지 드링크에 다른 에너지 드링크를 따라야 손실이 최소화된다.
        long energyDrink = IntStream.range(0, n - 1)
                .mapToLong(input1::get)
                .sum();

        long targetEnergyDrink = input1.get(n - 1);

        double energyDrink1 = (double) energyDrink / 2;
        double answer = energyDrink1 + targetEnergyDrink;

        // answer 정수 표현이라면 정수로 출력
        if(answer == (int) answer) {
            System.out.println((int) answer);
        } else {
            System.out.println(answer);
        }
    }
}