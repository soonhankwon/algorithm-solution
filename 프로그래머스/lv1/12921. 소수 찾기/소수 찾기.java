import java.util.stream.IntStream;

class Solution {
    
    static int answer;
    
    public int solution(int n) {
        answer = 0;
        IntStream.rangeClosed(1, n).forEach(i -> {
            if(isPrimeNumber(i))
                answer++;
        });
        return answer;
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