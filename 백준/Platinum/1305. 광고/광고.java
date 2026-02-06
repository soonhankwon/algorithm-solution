import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String s = br.readLine();
        
        // KMP 실패 함수(pi 배열)
        // pi[i]: 0부터 i까지의 부분 문자열 중, 접두사와 접미사가 일치하는 최대 길이
        int[] pi = new int[L];
        int j = 0;
        for(int i = 1; i < L; i++) {
            // 일치하지 않으면 j를 이전 일치 구간으로 되돌림
            while(j > 0 && s.charAt(i) != s.charAt(j)) {
                j = pi[j - 1];
            }
            // 문자가 일치하면 j를 증가시키고 pi 배열에 기록
            if(s.charAt(i) == s.charAt(j)) {
                j++;
                pi[i] = j;
            }
        }
        // 전체 길이 - (접두사와 접미사가 일치하는 가장 긴 길이)
        System.out.println(L- pi[L-1]);
    }
    
}