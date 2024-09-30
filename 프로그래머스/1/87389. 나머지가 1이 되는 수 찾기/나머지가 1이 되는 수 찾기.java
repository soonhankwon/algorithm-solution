class Solution {
    public int solution(int n) {
        boolean isExists = false;
        int answer = 2;
        while(!isExists) {
            if(n % answer == 1) {
                break;
            }
            ++answer;
        }
        return answer;
    }
}