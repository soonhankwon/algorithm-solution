class Solution {
    public int solution(String my_string, String is_prefix) {
        char[] cArr = my_string.toCharArray();
        int answer = 1;
        int prefixLength = is_prefix.length();
        if(my_string.length() < prefixLength) {
            return 0;
        }
        for(int i = 0; i < prefixLength; i++) {
            if(cArr[i] != is_prefix.charAt(i)) {
                return 0;
            }
        }
        return answer;
    }
}