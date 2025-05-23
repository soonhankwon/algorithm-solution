import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 목표상태: 한 기둥에 쌓여 있는 원반들을 다른 기둥으로 옮기는 것
 */
public class Main {

    private static final StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 원반의 개수 n
        int n = Integer.parseInt(br.readLine());
        // 하노이탑의 최소 이동 횟수는 2^n - 1(비트연산자 활용)
        BigInteger num = BigInteger.ONE.shiftLeft(n).subtract(BigInteger.ONE);
        sb.append(num);
        // n이 20 이하일 때만 이동 과정을 출력 (n이 크면 출력량이 너무 많아짐)
        if(n <= 20) {
            sb.append("\n");
            // 재귀 함수 호출: n개의 원반을 1번 기둥에서 3번 기둥으로 옮기기
            recursion(n, 1, 3);
        }
        System.out.println(sb);
        br.close();
    }

    /**
     * @param n 옮길 원반의 개수
     * @param start 시작 기둥 번호
     * @param end 목표 기둥 번호
     */
    private static void recursion(int n, int start, int end) {
        // 기저 조건: 옮길 원반이 없으면 종료
        if(n == 0) {
            return;
        }
        // 중간 기둥 번호 계산 (1+2+3=6이므로 6-start-end는 나머지 기둥)
        int mid = 6 - start - end;
        // 1단계: n-1개의 원반을 시작 기둥에서 중간 기둥으로 옮김
        recursion(n - 1, start, mid);
        // 2단계: 가장 큰 원반을 시작 기둥에서 목표 기둥으로 옮김
        sb.append(start).append(" ").append(end).append("\n");
        // 3단계: n-1개의 원반을 중간 기둥에서 목표 기둥으로 옮김
        recursion(n - 1, mid, end);
    }
}