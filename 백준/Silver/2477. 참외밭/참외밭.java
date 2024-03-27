import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1 -> 2
        // 3 -> 2
        // 2 -> 1 (직선을 의미)
        // 4 -> 1 (직선을 의미)

        // 1.가장 큰 변들은 항상 붙어있다.
        // 2.패턴1: 1,2,3,4로 가다 동일숫자가 나오는 그 타이밍이 꺽이는 두 변이다.
        // 3.패턴2: 1,2,3,4를 모두가고 마지막 2번째 1,2 꺽이는 두변
        // 4.패턴3: 4 2 [3 1 3 1]
        // 5.가장 큰 변들에서 세 번지나가면 항상 꺽이는 변이다. 때문에 인덱스 +3

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //7

        int hMax = Integer.MIN_VALUE;
        int wMax = Integer.MIN_VALUE;
        int hMaxIndex = Integer.MIN_VALUE;
        int wMaxIndex = Integer.MIN_VALUE;

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int inputDirection = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            pairs.add(new Pair(inputDirection, length));

            Pair pair = pairs.get(i);
            int direction = pair.direction;
            int pairLength = pair.length;
            // west or east - south or north
            if (direction == 1 || direction == 2) {
                if (wMax < pairLength) {
                    wMaxIndex = i;
                }
                wMax = Math.max(wMax, pairLength);
            } else {
                if (hMax < pairLength) {
                    hMaxIndex = i;
                }
                hMax = Math.max(hMax, pairLength);
            }
        }
        int bigSquare = wMax * hMax;
        // index + 3 일때 빈 사각형을 구할 수 있음 => 모듈러 연산을해야 인덱스를 벗어나지 않음
        int smallSquare = pairs.get((wMaxIndex + 3) % 6).length * pairs.get((hMaxIndex + 3) % 6).length;
        System.out.println((bigSquare - smallSquare) * n);
    }

    public static class Pair {
        int direction;
        int length;

        public Pair(int direction, int length) {
            this.direction = direction;
            this.length = length;
        }
    }
}
