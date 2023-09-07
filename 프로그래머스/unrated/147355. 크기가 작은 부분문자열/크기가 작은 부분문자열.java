class Solution {
    public int solution(String t, String p) {
        int startIndex = 0;
        int endIndex = p.length() - 1;
        
        int tLength = t.length();
        long standardValue = Long.parseLong(p);
        int answer = 0;

        for(long i = 0; i < tLength; i++) {
            if(endIndex == tLength) {
                break;
            }
            String data = t.substring(startIndex, endIndex + 1);
            if(Long.parseLong(data) <= standardValue) {
                answer++;
            }
            startIndex++;
            endIndex++;
        }
        return answer;
    }
}