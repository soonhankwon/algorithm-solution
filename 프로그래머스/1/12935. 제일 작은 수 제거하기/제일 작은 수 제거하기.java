import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length == 1) {
            arr[0] = -1;
            return arr;
        }
        int min = Arrays.stream(arr).min().getAsInt();
        int[] answer = new int[arr.length - 1];
        boolean isExists = false;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == min) {
                isExists = true;
                continue;
            }
            if(isExists) {
                answer[i - 1] = arr[i];    
            } else {
                answer[i] = arr[i];    
            }
        }
        return answer;
    }
}