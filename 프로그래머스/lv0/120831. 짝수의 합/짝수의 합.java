class Solution {
    public int solution(int n) {
        int num = 0;
        int sum = 0;
        int temp;
        for(int i = 0; i < n / 2; i++) {
            num += 2;
            temp = sum + num;
            sum = temp;
        }
        return sum;
    }
}