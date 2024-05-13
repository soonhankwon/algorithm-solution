import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 보이드-무어 문자열 매칭
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String originStr = br.readLine();
        String bombStr = br.readLine();

        int originStrLength = originStr.length();
        int bombStrLength = bombStr.length();
        char lastChar = bombStr.charAt(bombStrLength - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < originStrLength; i++) {
            char nowChar = originStr.charAt(i);
            sb.append(nowChar);
            int sbLength = sb.length();
            // 현재 문자가 폭발 분자열의 끝과 일치하는 경우, 그 전 문자열이 폭발 문자열과 일치하는지 확인
            if (nowChar == lastChar && sbLength >= bombStrLength) {
                int startIndex = sbLength - bombStrLength;
                String lastChars = sb.substring(startIndex, sbLength);
                
                // 일치한다면 폭발 문자열 제거
                if (lastChars.equals(bombStr)) {
                    sb.delete(startIndex, sbLength);
                }
            }
        }

        String answer = sb.toString();
        if (answer.isEmpty()) {
            System.out.println("FRULA");
            return;
        }
        System.out.println(answer);
        br.close();
    }
}