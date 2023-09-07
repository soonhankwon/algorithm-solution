class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr2[0].length;
        int index = 0;
        for(int[] data : arr1) {
            for(int i = 0; i < n; i++) {
                data[i] += arr2[index][i];
            }
            index++;
        }
        return arr1;
    }
}