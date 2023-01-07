import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        int length = (int)(Math.log10(n) + 1);
        Long[] arr = new Long[length];
        for(int i = 0; i< length; i++){
            arr[i] = n%10;
            n /= 10;
        }
        Arrays.sort(arr, Collections.reverseOrder());
        for(Long num : arr){
            answer *= 10;
            answer += num;
        }
        return answer;
    }
}