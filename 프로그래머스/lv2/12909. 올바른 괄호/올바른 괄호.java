class Solution {
    boolean solution(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == ')' || chars[chars.length - 1] != ')') {
            return false;
        }

        int count = 0;
        for (char aChar : chars) {
            if (aChar == '(') {
                count++;
            } else {
                count--;
                if(count < 0) {
                    return false;
                }
            }
        }
        return count == 0;
    }
}
