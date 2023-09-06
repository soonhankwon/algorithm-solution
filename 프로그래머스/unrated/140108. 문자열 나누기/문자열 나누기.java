class Solution {
    public int solution(String s) {
        int xCount = 0;
        int yCount = 0;
        int sLength = s.length();
        
        int answer = 0;
        String x = null;
        
        if(sLength == 1) {
            return 1;
        }
        
        for(int i = 0; i < sLength; i++) {
            if(i == 0) {
                x = String.valueOf(s.charAt(i));
                xCount++;
                continue;
            }
            
            if(String.valueOf(s.charAt(i)).equals(x)) {
                xCount++;
            } 
            else {
                yCount++;
            }
            
            if(xCount == yCount) {
                if(i < sLength - 1) {
                    x = String.valueOf(s.charAt(i+1));   
                }
                xCount = 0;
                yCount = 0;
                answer++;
            } else {
                if(i == sLength - 1) {
                    answer++;
                }
            }
            
        }
        return answer;
    }
}