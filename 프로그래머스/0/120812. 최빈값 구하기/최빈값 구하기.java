class Solution {
    public int solution(int[] array) {
        if(array.length == 0) {
            return -1;
        }
        int[] arr = new int[1001];
        int max = 0;
        for(int i = 0; i < array.length; i++) {
            ++arr[array[i]];
            max = Math.max(max, arr[array[i]]);
        }
        int cnt = 0;
        int answer = -1;
        for(int i = 0; i <= 1000; i++) {
            if(arr[i] == max) {
                answer = i;
                ++cnt;
            }
        }
        return cnt > 1 ? -1 : answer;
    }
}