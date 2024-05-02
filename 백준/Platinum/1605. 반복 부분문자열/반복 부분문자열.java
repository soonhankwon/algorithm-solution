import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/*
 * 라빈-카프 알고리즘
 */
public class Main {

    static final int PRIME = 31; // 해싱에 사용할 소수
    static final int MOD = (int) 1e9 + 9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int length = str.length();
        long[] hash = new long[n + 1]; // 문자열의 해시값 저장 배열
        long[] pow = new long[n + 1]; // PRIME 거듭제곱을 미리 계산한 배열
        pow[0] = 1;

        // 미리 거듭제곱 계산
        for (int i = 1; i <= n; i++) {
            pow[i] = (pow[i - 1] * PRIME) % MOD;
        }

        // 문자열의 해시값 계산 - 음수방지
        for (int i = 0; i < n; i++) {
            hash[i + 1] = (hash[i] + (str.charAt(i) - 'a' + 1) * pow[i]) % MOD;
            if (hash[i + 1] < 0) {
                hash[i + 1] += MOD;
            }
        }

        // 반복 문자열 이진탐색으로 탐색
        int left = 0;
        int right = length;
        int maxLength = 0;
        HashMap<Long, Integer> hashMap = new HashMap<>(); // 해시 충돌 저장을 위한 HashMap
        while (left <= right) {
            int mid = (left + right) / 2;
            boolean isFound = false;

            // 길이가 mid인 부분문자열의 해시값을 모두 계산하여 map에 저장
            for (int i = 0; i <= n - mid; i++) {
                if (i + mid <= n) { // 배열 인덱스가 범위를 벗어나지 않도록 확인
                    long curHash = (hash[i + mid] - hash[i] + MOD) % MOD;
                    curHash = (curHash * pow[n - i - mid]) % MOD;
                    if (hashMap.containsKey(curHash)) {
                        // 해시 충돌이 발생한 경우, 추가적으로 문자열을 비교하여 정확한 반복 부분문자열인지 확인
                        int startPos = hashMap.get(curHash); // 두 번째 부분문자열의 시작 위치
                        if (str.substring(i, i + mid).equals(str.substring(startPos, startPos + mid))) {
                            isFound = true;
                            break;
                        }
                    }
                    hashMap.put(curHash, i);
                }
            }

            // 중복되는 부분 문자열이 있다면 길이를 늘려서 다시 탐색
            if (isFound) {
                maxLength = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            hashMap.clear();
        }

        System.out.println(maxLength);
        br.close();
    }
}

