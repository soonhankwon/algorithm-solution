class Solution {
    public boolean solution(int x) {
        if (x < 10) {
            return true;
        }

        int sum = 0;
        char[] chars = String.valueOf(x).toCharArray();
        for (char aChar : chars) {
            sum += aChar - 48;
        }

        return x % sum == 0;
    }
}