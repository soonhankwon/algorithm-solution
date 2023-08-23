class Solution {
    public int solution(int[] number) {
        int answer = 0;
        int length = number.length;
        
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    if(i == j || j == k || k == i) {
                        continue;
                    }
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}