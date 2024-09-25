class Solution {
    public int[] solution(int n) {
        int[] arr;
        if(n % 2 == 0) {
            arr = new int[n / 2];
        } else {
            arr = new int[n / 2 + 1];
        }
        int index = 0;
        for(int i = 1; i <= n; i++) {
            if(i % 2 == 1) {
                arr[index] = i;
                ++index;
            }
        }
        return arr;
    }
}