import java.util.Arrays;

class Solution {
    public int solution(int n) {
        int count = recursion(n, 0);
        StringBuilder sb = new StringBuilder();
        for(int i = count - 1; i >= 0; i--) {
            int temp = n / (int) Math.pow(3, i);
            n = n % (int) Math.pow(3, i);
            sb.append(String.valueOf(temp));
        }
        
        String[] data = sb.toString().split("");
        int dataLength = data.length;
        String[] reverseArr = new String[dataLength];
        for(int i = 0; i < dataLength; i++) {
            reverseArr[i] = data[dataLength - i - 1];             
        }
        
        int answer = 0;
        for(int i = 0; i < dataLength; i++) {
            answer += Integer.parseInt(reverseArr[i]) * Math.pow(3, dataLength - i - 1);     
        }
        return answer;
    }
    
    private int recursion(int a, int index) {
        if(a == 0)
            return index;
        
        return recursion(a / 3, index + 1);
    }
}