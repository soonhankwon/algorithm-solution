import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str0 = br.readLine();
        String str1 = br.readLine();
        String answer = "NO";
        if (str0.charAt(0) != str1.charAt(0) || str0.charAt(n - 1) != str1.charAt(n - 1)) {
            System.out.println(answer);
            return;
        }

        int[] charCnt0 = new int[26];
        int[] charCnt1 = new int[26];

        StringBuilder sb0 = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c0 = str0.charAt(i);
            char c1 = str1.charAt(i);
            charCnt0[c0 - 'a']++;
            charCnt1[c1 - 'a']++;
            if (isConsonant(c0)) {
                sb0.append(c0);
            }
            if (isConsonant(c1)) {
                sb1.append(c1);
            }
        }

        if (!sb0.toString().contentEquals(sb1)) {
            System.out.println("NO");
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (charCnt0[i] != charCnt1[i]) {
                System.out.println("NO");
                return;
            }
        }

        answer = "YES";
        System.out.println(answer);
        br.close();
    }

    private static boolean isConsonant(char c) {
        return c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u';
    }
}