import java.util.function.BiFunction;

class Solution {
    public int solution(int n, int k) {
        int drinkService = n / 10;
        k -= drinkService;
        BiFunction<Integer, Integer, Integer> function = (a, b) -> a * 12000 + b * 2000;
        return function.apply(n, k);
    }
}