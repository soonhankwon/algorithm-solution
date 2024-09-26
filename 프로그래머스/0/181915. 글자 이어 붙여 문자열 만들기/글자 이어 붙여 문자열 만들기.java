class Solution {
    public String solution(String my_string, int[] index_list) {
        char[] cArr = my_string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i : index_list) {
            sb.append((char) cArr[i]);
        }
        return sb.toString();
    }
}