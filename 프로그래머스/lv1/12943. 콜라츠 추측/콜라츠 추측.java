class Solution {
    public int solution(int num) {
        long n = num;
        int cnt = 0;
        while(true){
            if(n == 1) return cnt;
            if(cnt >500) return -1;
            if(n%2 == 0){
                n /= 2;
                cnt++;
            } else{
                n = n*3 + 1;
                cnt++;
            }
        }
    }
}