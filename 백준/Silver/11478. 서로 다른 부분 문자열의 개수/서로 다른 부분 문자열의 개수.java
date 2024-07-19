import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static String str;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        int length = str.length();
        // 부분 문자열의 개수 계산
        int substrings = length * (length + 1) / 2;
        // 로드 팩터를 고려하여 약간 더 크게 설정
        int capacity = (int) (substrings / 0.75) + 1;
        // 다음 2의 거듭제곱으로 반올림
        capacity--;
        capacity |= capacity >>> 1;
        capacity |= capacity >>> 2;
        capacity |= capacity >>> 4;
        capacity |= capacity >>> 8;
        capacity |= capacity >>> 16;
        capacity++;
        Set<String> set = new HashSet<>(capacity);
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length + 1; j++) {
                set.add(str.substring(i, j));
            }
        }
        System.out.println(set.size());
        br.close();
    }
}