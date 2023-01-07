import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i <= sum/2; i++){
            if(sum%i == 0){
                list.add(i);
            }
        }
        list.add(sum);
        int size = list.size();
        int area = 0;
        if(size%2 == 0){
            area = size/2;
        } else{
            area = size/2 + 1;
        }
        for(int i = 0; i < area; i++){
            int a = list.get(i);
            int b = list.get(size - 1 -i);
            if((a - 2) * (b - 2) == yellow && (2*a) + (2*b) - 4 == brown){
                answer[0] = b;
                answer[1] = a;
            }
        }
        return answer;
    }
}