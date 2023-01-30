class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left + 1)];
        int index = 0;
        for(long i = left; i <= right; i++){
            long mok = i/n;
            long na = i%n;
            long num = Math.max(mok, na) + 1;
            answer[index] = (int)num;
            index++;
        }
        return answer;
    }
}