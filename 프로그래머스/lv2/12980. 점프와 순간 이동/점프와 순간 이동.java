public class Solution {
    public int solution(int n) {
        int answer = 0;
        while(true){
            if(n == 0) break;
            if(n % 2 == 1){
                answer += 1;
                n -= 1;
            } else{
                n /= 2;
            }
        }
        return answer;
    }
}