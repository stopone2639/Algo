import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        if(s.length() % 2 != 0){
            answer = false;
            return answer;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                if(stack.empty()){
                    answer = false;
                    return answer;
                } else{
                    stack.pop();
                }        
            } else{
                stack.push(s.charAt(i));
            }
        }
        if(stack.empty()){
            answer = true;
        } else{
            answer = false;
        } 
        return answer;
    }
}
