import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String plainText = br.readLine();
        String cipherText = br.readLine();
        int length = plainText.length();
        for(int i = 1; i <= length; i++) {
            // 키가 반복되려면 길이가 약수여야함!
            if(length % i != 0) {
                continue;
            }
            StringBuilder key = new StringBuilder();
            boolean isValid = true;
            for(int j = 0; j < i; j++) {
                int plainValue = plainText.charAt(j) - 'A' + 1;
                int cipherValue = cipherText.charAt(j) - 'A' + 1;
                int keyValue = cipherValue - plainValue;
                if(keyValue <= 0) {
                    keyValue += 26;
                }
                key.append((char) ('A' + keyValue - 1));
            }
            // 키 검증
            for(int j = 0; j < length; j++) {
                int plainValue = plainText.charAt(j) - 'A' + 1;
                int keyValue = key.charAt(j % i) - 'A' + 1;
                int expectedKey = plainValue + keyValue;
                if(expectedKey > 26) {
                    expectedKey -= 26;
                }
                if((char)('A' + expectedKey - 1) != cipherText.charAt(j)) {
                    isValid = false;
                    break;
                }
            }
            if(isValid) {
                System.out.println(key);
                break;
            }
        }
        br.close();
    }
}