import java.util.*;
class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            int num = check(i);
            if(num % 2 == 0){
                answer += i;
            } else{
                answer -= i;
            }
        }        
        return answer;
    }
    public int check(int num){
        int cnt = 0;
        for(int i = 1; i <= Math.sqrt(num); i++){
            if(Math.sqrt(num) == i) cnt++;
            else if(num % i == 0) cnt += 2;
        }
        return cnt;
    }
}