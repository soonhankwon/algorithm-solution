class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < food.length; i++) {
            if (i == 0) {
                continue;
            }
            int number = (int) Math.floor(food[i] / 2);
            sb.append(String.valueOf(i)
                    .repeat(Math.max(0, number)));
        }
        String leftParticipantResult = sb.toString();
        sb.append(0);
        sb.reverse();
        return leftParticipantResult + sb;
    }
}