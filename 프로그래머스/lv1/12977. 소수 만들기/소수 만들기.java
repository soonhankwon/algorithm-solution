class Solution {
    
    static int answer;
    static int[] data;
    
    public int solution(int[] nums) {
        answer = 0;
        data = nums;
        recursion(0, 0, 0, new int[3]);
        return answer;
    }
    
    private void recursion(int index, int selectedCount, int sum, int[] selected) {
        if(selectedCount == 3) {
            if(isPrimeNumber(sum)) {
                answer++;
            }
            System.out.println(index + " " + sum);
            return;
        }

        if(index >= data.length)
            return;
        // 현재 인덱스의 숫자를 선택하는 경우
        selected[selectedCount] = 0;
        recursion(index + 1, selectedCount + 1, sum + data[index], selected);

        // 현재 인덱스의 숫자를 선택하지 않는 경우
        selected[selectedCount] = 0;
        recursion(index + 1, selectedCount, sum, selected);
    }

    private boolean isPrimeNumber(int number) {
        if (number <= 1)
            return false;
        if (number == 2)
            return true;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}