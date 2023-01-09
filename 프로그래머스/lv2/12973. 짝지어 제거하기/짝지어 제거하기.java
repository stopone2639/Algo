import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        Stack<String> stack = new Stack<>();
        String[] arr = s.split("");
        for(String str: arr){
            if(stack.empty()){
                stack.push(str);
            } else{
                if(str.equals(stack.peek())){
                    stack.pop();
                } else{
                    stack.push(str);
                }
            }
        }
        if(stack.empty()){
            answer = 1;
        }
        return answer;
    }
}