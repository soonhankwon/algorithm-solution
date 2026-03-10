import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * Input: MKM
         * Output:
         * 501 최대값
         * 151 최소값
         * 해결법: Greedy
         * 1. MK 패턴을 최대한 사용하면 최대값 MK | M -> 501
         * 1.1 문자열을 순회하면서 MK 패턴으로 최대한 묶어줌
         * 2. MK 패턴을 최대한 짧게 사용하면 최소값 M | K | M -> 151
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();

        // 1. 최대값 구하기
        int mCount = 0;
        int length = str.length();
        for(int i = 0; i < length; i++) {
            if(str.charAt(i) == 'M') {
                mCount++;
            } else {
                sb.append(5);
                sb.append("0".repeat(mCount));
                mCount = 0;
            }
        }
        sb.append("1".repeat(mCount)); // 1로 처리
        mCount = 0;
        sb.append("\n");

        // 2. 최소값 구하기
        for(int i = 0; i < length; i++) {
            if(str.charAt(i) == 'M') {
                mCount++;
            } else {
                if(mCount > 0) {
                    sb.append(1);
                    sb.append("0".repeat(mCount - 1));
                    mCount = 0;
                }
                sb.append(5);
            }
        }
        if(mCount > 0) {
            sb.append(1);
            sb.append("0".repeat(mCount - 1));
        }
        System.out.println(sb);
        br.close();
    }
}
