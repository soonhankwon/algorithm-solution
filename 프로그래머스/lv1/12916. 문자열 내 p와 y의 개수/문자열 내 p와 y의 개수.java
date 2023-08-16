import java.util.Arrays;

class Solution {
    boolean solution(String s) {
        long pCount = Arrays.stream(s.split("")).map(String::toLowerCase).filter(i -> i.equals("p")).count();
        long yCount = Arrays.stream(s.split("")).map(String::toLowerCase).filter(i -> i.equals("y")).count();
        return pCount == yCount;
    }
}