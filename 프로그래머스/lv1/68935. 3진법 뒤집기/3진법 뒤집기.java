import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        while(true){
            stack.add(n%3);
            n = n / 3;
            if(n == 0)break;
        }
        int cnt = 0;
        while(!stack.isEmpty()){
            answer += stack.pop() * (Math.pow(3,cnt));
            cnt++;
        }
        return answer;
    }
}