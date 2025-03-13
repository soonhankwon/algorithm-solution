import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(countSwaps());
        br.close();
    }

    public static long countSwaps() {
        int[] temp = new int[arr.length];
        return mergeSort(temp, 0, arr.length - 1);
    }

    public static long mergeSort(int[] temp, int left, int right) {
        // 병합 정렬의 종료 조건
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        long cnt = 0;
        // 왼쪽과 오른쪽을 나누어 정렬하고 swap 횟수를 계산
        cnt += mergeSort(temp, left, mid);
        cnt += mergeSort(temp, mid + 1, right);
        // 병합 과정에서 swap 횟수를 계산
        cnt += merge(temp, left, mid, right);
        return cnt;
    }

    public static long merge(int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        long cnt = 0;
        // 병합 과정에서 swap 횟수를 계산
        while (i <= mid && j <= right) {
            // 왼쪽 배열과 오른쪽 배열의 요소를 비교하여 작은 값을 temp 배열에 삽입하기 위한 조건
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                // 왼쪽 배열의 남아있는 요소 개수만큼 swap 발생
                cnt += mid - i + 1;
            }
        }
        // 남아있는 요소들을 병합
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        // temp의 내용을 원래 배열로 복사
        System.arraycopy(temp, left, arr, left, right - left + 1);
        return cnt;
    }
}