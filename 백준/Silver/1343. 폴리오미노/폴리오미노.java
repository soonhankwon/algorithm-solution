import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         * 가진 폴리오미노는 2개뿐 AAAA, BB
         * X를 모두 폴리오미노로 덮으려고하는데, .은 덮으면 안됨
         * 사전순으로 가장 앞서는 답 출력, 덮을 수 없으면 -1
         * 해결법:
         * 1. 문자열을 순회하면서 X의 개수를 셈
         * 2. 문자열이 X가 나오면 카운트업, . 또는 마지막 인덱스면 판별해야함
         * 3. .이 나온경우 카운트가 홀수면 -1 출력 후 종료, 짝수면 AAAA, BB 순서대로 문자열을 붙임
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String board = br.readLine();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char[] chars = board.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == 'X') {
                count++;
            }

            if (c == '.' || i == chars.length - 1) {
                if (count % 2 != 0) {
                    sb.setLength(0);
                    sb.append(-1);
                    break;
                }

                sb.append("AAAA".repeat(count / 4));
                sb.append("BB".repeat(count % 4 / 2));
                count = 0;
                if(c == '.') {
                    sb.append(".");
                }
            }
        }
        System.out.println(sb);
        br.close();
    }
}
