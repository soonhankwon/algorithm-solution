class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        if (!cards1[0].equals(goal[0]) && !cards2[0].equals(goal[0]))
            return "NO";

        if (cards1.length + cards2.length < goal.length)
            return "NO";

        StringBuilder sb = new StringBuilder();
        for (String g : goal) {
            sb.append(g);
        }
        String goalAnswer = sb.toString();
        sb.setLength(0);

        int card1Index = 0;
        int card2Index = 0;
        int goalIndex = 0;
        while (goalIndex < goal.length) {
            if (card1Index < cards1.length && cards1[card1Index].equals(goal[goalIndex])) {
                sb.append(cards1[card1Index]);
                card1Index++;
            }
            else {
                if(card2Index < cards2.length) {
                    sb.append(cards2[card2Index]);
                    card2Index++;
                }
            }
            goalIndex++;
        }
        System.out.println(sb);
        if (sb.toString().equals(goalAnswer))
            return "Yes";
        else
            return "No";
    }
}