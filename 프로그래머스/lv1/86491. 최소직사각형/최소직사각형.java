class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MIN_VALUE;
        for(int i = 0; i < sizes.length; i++){
            int A = sizes[i][0];
            int B = sizes[i][1];
            int maxNum = Math.max(A, B);
            int minNum = Math.min(A, B);
            max = Math.max(maxNum, max);
            min = Math.max(minNum, min);
        }
        answer = max * min;
        return answer;
    }
}