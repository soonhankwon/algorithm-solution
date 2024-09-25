class Solution {
    public String solution(String[] seoul) {
        String answer = "김서방은 ";
        int index = 0;
        for(String person : seoul) {
            if(person.equals("Kim")) {
                answer += String.valueOf(index) + "에 있다";
            }
            ++index;
        }
        return answer;
    }
}