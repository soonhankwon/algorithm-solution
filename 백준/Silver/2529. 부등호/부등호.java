import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String maxResult = "";
    static String minResult = "";
    static int visited = 0;
    static int[] nums;
    static String[] signs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        signs = br.readLine().split(" ");
        nums = new int[k + 1];

        dfs(0, k);

        System.out.println(maxResult);
        System.out.println(minResult);
        br.close();
    }

    public static void dfs(int depth, int k) {
        // k+1개의 숫자를 모두 선택한 경우
        if(depth == k + 1) {
            // 부등호 관계가 맞는지 확인
            if(check()) {
                // 현재 수를 문자열로 변환
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i <= k; i++) {
                    sb.append(nums[i]);
                }
                String curStr = sb.toString();
                // 최대, 최소 값 갱신
                if(maxResult.isEmpty() || maxResult.compareTo(curStr) < 0) {
                    maxResult = curStr;
                }
                if(minResult.isEmpty() || minResult.compareTo(curStr) > 0) {
                    minResult = curStr;
                }
            }
            return;
        }
        // 0부터 9까지 숫자 선택
        for(int i = 0; i < 10; i++) {
            if((visited & (1 << i)) == 0) {
                visited |= (1 << i);
                nums[depth] = i;
                dfs(depth + 1, k);
                visited &= ~(1 << i);
            }
        }
    }
    
    // 부등호 관계가 맞는지 확인하는 함수
    public static boolean check() {
        for(int i = 0; i < signs.length; i++) {
            if(signs[i].equals("<") && nums[i] >= nums[i + 1]) return false;
            if(signs[i].equals(">") && nums[i] <= nums[i + 1]) return false;
        }
        return true;
    }
}