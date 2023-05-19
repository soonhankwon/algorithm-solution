import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws IOException {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		char[] words = new char[s.length()];
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		char[] alphabetList = new char[alphabet.length()];
		
		int[] answerSheet = new int[alphabet.length()];
		
		for(int i=0; i<alphabet.length(); i++) {
			alphabetList[i] = alphabet.charAt(i);
			answerSheet[i] = -1;
			
			for(int j=0; j<s.length(); j++) {
				words[j] = s.charAt(j);
				if(alphabetList[i] == words[j]) {
					answerSheet[i] = j;
					break;
				} 
			}
		}
		for(int i: answerSheet) {
			System.out.print(i + " ");
		}
	} 
}