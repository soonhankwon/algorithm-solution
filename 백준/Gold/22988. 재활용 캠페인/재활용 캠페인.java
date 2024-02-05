import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 총 용량 Xml 헤어에센스
        // 두 개를 반납하면 새로운 용기에 남은 헤어에센스를 모아 준다.
        // 추가로 총 용량의 절반만큼의 헤어에센스를 추가로 채워준다.
        // 단 총 용량을 넘쳐서 채워주지 않는다.
        // eg) 0, 1 -> 0 + 1 + 6.5(13/2) = 7.5ml
        // 2,3 -> 2 + 3 + 6.5 = 11.5ml
        // 4,5 -> 5 + 8 + 6.5 = 13ml 1개
        // 6 -> 13ml 1개
        // (0,1) + (2,3) -> 7.5 + 11.5 + 6.5 = 13ml 1개 -> 총 3개

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        long[] nums = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::valueOf)
                .sorted()
                .toArray();
        // 0 1 2 3 5 8 13
        // two-pointer
        int index1 = 0;
        int index2 = 0;
        long answer = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == x) {
                answer++;
                n--;
            } else {
                index2 = i;
                break;
            }
        }
        double availableEventAmount = (double) x / 2;
        while (index1 < index2) {
            long sum = nums[index1] + nums[index2];
            if (sum >= availableEventAmount) {
                answer++;
                n -= 2;
                index1++;
                index2--;
                continue;
            }
            if (sum < x) {
                index1++;
            }
        }

        answer += n / 3;
        System.out.println(answer);
    }
}