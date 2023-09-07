class Solution {
    public String solution(String s, int n) {
        char[] c = s.toCharArray();
        int cLength = c.length;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < cLength; i++) {
            char nowChar = c[i];
            if(nowChar == 32) {
                sb.append(" ");
                continue;
            }
            if(nowChar + n > 122 && nowChar >= 97) {
                sb.append((char)(nowChar + n - 26));
                continue;
            } else if (nowChar >= 97) {
                sb.append((char)(nowChar + n));
                continue;
            }
            
            if(nowChar + n > 90 && nowChar >= 65) {
                sb.append((char)(nowChar + n - 26));
                continue;
            } else if (nowChar >= 65) {
                sb.append((char)(nowChar + n));
                continue;
            }
            sb.append((char)(nowChar + n));
        }
        
        return sb.toString();
    }
}