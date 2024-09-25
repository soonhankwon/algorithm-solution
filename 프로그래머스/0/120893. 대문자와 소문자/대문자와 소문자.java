class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        char[] cArr = my_string.toCharArray();
        for(int i = 0; i < cArr.length; i++) {
            char c = my_string.charAt(i);
            if(c >= 97 && c <= 123) {
                c -= 32;
                sb.append(String.valueOf(c));
            } else {
                c += 32;
                sb.append(String.valueOf(c));
            }
        }
        return sb.toString();
    }
}