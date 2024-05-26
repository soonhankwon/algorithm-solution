import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 이분탐색, 분리집합
 */
public class Main {

    static int[] arr, cards;
    static int n, m, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        n = inputs[0]; // 카드의 숫자
        m = inputs[1]; // M개의 카드를 고름
        k = inputs[2]; // K번 동작

        cards = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Arrays.sort(cards);

        int[] magician = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        StringBuilder sb = new StringBuilder();
        arr = new int[m];
        Arrays.fill(arr, -1);
        for (int card : magician) {
            int position = binarySearch(card);
            position = find(position);
            union(position, position + 1);
            sb.append(cards[position]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    static int binarySearch(int n) {
        int start = m - 1;
        int end = -1;
        while (start > end + 1) {
            int mid = (start + end) / 2;
            if (cards[mid] > n) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return start;
    }

    private static int find(int num) {
        if (arr[num] < 0) {
            return num;
        }
        return arr[num] = find(arr[num]);
    }

    private static void union(int num1, int num2) {
        if (num2 >= m) {
            return;
        }
        arr[num1] = num2;
    }
}
