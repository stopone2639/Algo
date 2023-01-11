import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int min = 0;
        int max = people.length - 1;
        while(true){
            if(people[min] + people[max] > limit){
                max--;
                answer++;
            } else{
                min++;
                max--;
                answer++;
            }
            if(min == max){
                answer++;
                break;
            }
            if(min > max){
                break;
            }
        }
        return answer;
    }
}