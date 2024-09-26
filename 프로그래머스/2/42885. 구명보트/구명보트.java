import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int answer = 0;
        
        while(left <= right) {
            // 가장 가벼운 사람 + 무거운 사람 == 무게제한을 넘지 않으면 둘 다 태움
            if(people[left] + people[right] <= limit) {
                left++;
            } 
            // 무게제한을 넘는 경우 -> 무거운 사람만 태움
            right--;
            // 각 회차마다 보트수++
            answer++;
        }
        return answer;
    }
}