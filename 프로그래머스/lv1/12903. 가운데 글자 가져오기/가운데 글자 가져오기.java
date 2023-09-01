class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int midIndex = s.length() / 2;
        if (s.length() % 2 == 0)
            return sb.append(s.charAt(midIndex - 1))
                    .append(s.charAt(midIndex))
                    .toString();

        return String.valueOf(s.charAt(midIndex));
    }
}