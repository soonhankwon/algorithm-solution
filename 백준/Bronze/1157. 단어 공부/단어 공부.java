import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine().toUpperCase();

		int[] A = new int[26];

		for (int i = 0; i < word.length(); i++) {
			if ('A' <= word.charAt(i) && word.charAt(i) <= 'Z') {
				A[word.charAt(i) - 'A']++;
			}
		}

		int max = -1;
		char ch = '?';

		for (int i = 0; i < 26; i++) {
			if (A[i] > max) {
				max = A[i];
				ch = (char) (i + 65);
			} else if (A[i] == max) {
				ch = '?';
			}
		}
		System.out.println(ch);
	}
}
