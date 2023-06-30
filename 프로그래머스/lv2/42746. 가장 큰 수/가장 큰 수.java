import java.util.Arrays;

class Solution {
    
    public String solution(int[] numbers) {
        String[] numbersArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersArr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numbersArr, (a, b) -> (b + a).compareTo(a + b));
        if(numbersArr[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String number : numbersArr) {
            sb.append(number);
        }

        return sb.toString();
    }
}