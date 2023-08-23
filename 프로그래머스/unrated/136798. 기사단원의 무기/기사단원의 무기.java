class Solution {
    
    static int requiredIron;
    
    public int solution(int number, int limit, int power) {
        requiredIron = 0;
        for(int i = 1; i <= number; i++) {
            if(isPrimeNumber(i)) {
                requiredIron += 2;
                continue;
            }
            int measureCount = 0;
            for(int j = 1; j <= i / 2; j++) {
                if(i % j == 0) {
                    measureCount++;
                }
                if(measureCount > limit) {
                    break;
                }
            }
            measureCount++;
            if(measureCount > limit) {
                requiredIron += power;
            } else {
                requiredIron += measureCount;
            }
        }
        return requiredIron;
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