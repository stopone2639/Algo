import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = n + "";
        char[] arr = s.toCharArray();
        for(char c : arr){
            int num = c - '0';
            answer += num;
        }
        return answer;
    }
}