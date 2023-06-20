import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        Queue<Integer> reserveList = new LinkedList<>();
        for (int reserveStudent : reserve) {
            reserveList.add(reserveStudent);
        }

        Queue<Integer> lostList = new LinkedList<>();
        for (int lostStudent : lost) {
            if (reserveList.contains(lostStudent)) {
                reserveList.remove(lostStudent);
            } else {
                lostList.add(lostStudent);
            }
        }
        
        // 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다.
        while (!reserveList.isEmpty() && !lostList.isEmpty()) {
            Integer poll = reserveList.poll();
            if(lostList.contains(poll - 1)) {
                lostList.remove(poll - 1);
            } else if (lostList.contains(poll + 1)){
                lostList.remove(poll + 1);
            }
        }
        
        return n - lostList.size();
    }
}