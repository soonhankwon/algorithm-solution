import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] blocks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int l = arr[0];
        int w = arr[1];
        int h = arr[2];
        int n = Integer.parseInt(br.readLine());
        blocks = new int[n][2];
        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            blocks[i][0] = row[0]; // 블록 크기의 지수
            blocks[i][1] = row[1]; // 블록 개수
        }
        System.out.println(fillBox(l, w, h));
        br.close();
    }

    public static int fillBox(int l, int w, int h) {
        Arrays.sort(blocks, (a, b) -> Integer.compare(b[0], a[0])); // 블록 크기 순으로 정렬 -> 그리디
        long totalCount = 0;
        long volume = (long) l * w * h; // 상자의 전체 부피
        long usedVolume = 0;
        for (int[] block : blocks) {
            long size = 1L << block[0]; // 블록의 한 변 크기
            int count = block[1];
            if (volume <= usedVolume) {
                break; // 상자를 이미 채웠다면 종료
            }
            long maxCount = (l / size) * (w / size) * (h / size); // 현재 크기로 채울 수 있는 최대 개수
            maxCount -= usedVolume / (size * size * size); // 이미 채워진 공간 제외
            long useCount = Math.min(count, maxCount);

            usedVolume += useCount * (size * size * size);
            totalCount += useCount;
        }
        // 상자를 다 채웠는지 확인
        if (usedVolume == volume) {
            return (int) totalCount;
        } else {
            return -1;
        }
    }
}