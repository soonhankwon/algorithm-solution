import java.util.stream.IntStream;

class Solution {
    
    private static int result;
    
    public int solution(int left, int right) {
        result = 0;
        IntStream.rangeClosed(left, right).forEach(i -> {
            if (isPrimeNumber(i)) {
                result += i;
            } else {
                if(i == 1) {
                    result -= i;
                    return;
                }
                int divisors = numberOfDivisors(i);
                if (divisors % 2 == 0)
                    result += i;
                else
                    result -= i;
            }
        });
        return result;
    }
    
    private static int numberOfDivisors(int num) {
        int count = 2;
        for (int i = 2; i <= num / 2 + 1; i++) {
            if (num % i == 0)
                count++;
        }
        return count;
    }

    private static boolean isPrimeNumber(int number) {
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