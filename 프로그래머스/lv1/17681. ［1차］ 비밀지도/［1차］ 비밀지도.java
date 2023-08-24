import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] firstMap = new String[n];
        String[] secondMap = new String[n];

        IntStream.range(0, arr1.length).forEach(i -> {
            StringBuilder s1 = new StringBuilder(Integer.toBinaryString(arr1[i]));
            StringBuilder s2 = new StringBuilder(Integer.toBinaryString(arr2[i]));
            if(s1.length() < n) {
                int zeroCnt = n - s1.length();
                s1.insert(0, "0".repeat(zeroCnt));
            }
            if(s2.length() < n) {
                int zeroCnt = n - s2.length();
                s2.insert(0, "0".repeat(zeroCnt));
            }

            firstMap[i] = s1.toString();
            secondMap[i] = s2.toString();
        });

        System.out.println(Arrays.toString(firstMap));
        System.out.println(Arrays.toString(secondMap));

        String[] answer = new String[n];
        for(int i = 0; i < firstMap.length; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < secondMap.length; j++) {
                if(firstMap[i].charAt(j) == secondMap[i].charAt(j)) {
                    if(firstMap[i].charAt(j) == '1')
                        sb.append("#");
                    else
                        sb.append(" ");
                } else {
                    sb.append("#");
                }
            }
            answer[i] = sb.toString();
        }

        return answer;
    }
}