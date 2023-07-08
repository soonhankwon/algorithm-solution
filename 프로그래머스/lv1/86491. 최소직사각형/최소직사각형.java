import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int[] widthCandidates = new int[sizes.length];
        int[] heightCandidates = new int[sizes.length];

        int index = 0;
        for (int[] size : sizes) {
            if(size[0] > size[1]) {
                widthCandidates[index] = size[0];
                heightCandidates[index] = size[1];
            } else {
                widthCandidates[index] = size[1];
                heightCandidates[index] = size[0];
            }
            index++;
        }

        Arrays.sort(widthCandidates);
        Arrays.sort(heightCandidates);

        return widthCandidates[widthCandidates.length - 1] * heightCandidates[widthCandidates.length - 1];
    }
}