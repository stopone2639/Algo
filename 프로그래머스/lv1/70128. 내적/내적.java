class Solution {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i = 0; i< a.length; i++){
            int mul = a[i] * b[i];
            answer += mul;
        }
        return answer;
    }
}