class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        int hiddenSpace = phone_number.length() - 4;
        sb.append("*".repeat(Math.max(0, hiddenSpace))).append(phone_number.substring(hiddenSpace));
        return sb.toString();
    }
}