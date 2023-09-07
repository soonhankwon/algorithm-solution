class Solution {
    
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int sLength = s.length();
        
        int tempIndex = 0;
        for(int i = 0; i < sLength; i++) {
            String nowStr = String.valueOf(s.charAt(i));
            if(nowStr.equals(" ")) {
                tempIndex = 0;
                sb.append(" ");
                continue;
            }
            
            if(tempIndex == 0) {
                sb.append(nowStr.toUpperCase());
                tempIndex++;
                continue;
            } 
            
            if(tempIndex % 2 == 0) {
                sb.append(nowStr.toUpperCase());
            } else {
                sb.append(nowStr.toLowerCase()); 
            }
            tempIndex++;
        }
        
        return sb.toString();
    }
}