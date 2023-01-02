class Solution {
    public long solution(long n) {
        long answer = 0;
        double dbx = Math.sqrt(n);
        long x = (long) dbx;
        if(x == dbx){
            answer = (long)Math.pow(x+1, 2);
        } else{
            answer = -1;
        }
        return answer;
    }
}