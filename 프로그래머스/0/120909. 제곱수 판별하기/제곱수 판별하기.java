class Solution {
    public int solution(int n) {
        for(int i = 1; i <= Math.sqrt(n); i++) {
            if(Math.pow(i, 2) == n) {
                return 1;
            }
        }
        return 2;
    }
}