class Solution {
    public int solution(int[] num_list) {
        StringBuilder sb0 = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        for(int num : num_list) {
            if(num % 2 != 0) {
                sb0.append(num);
            } else {
                sb1.append(num);
            }
        }
        return Integer.valueOf(sb0.toString()) + Integer.valueOf(sb1.toString());
    }
}