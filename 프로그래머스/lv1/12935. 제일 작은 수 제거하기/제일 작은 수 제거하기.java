import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i< arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            } 
        }
        if(arr.length == 1){
            int[] answer = {-1};
            return answer;
        } else{
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < arr.length; i++){
                if(arr[i] != min){
                    list.add(arr[i]);
                }
            }
            int[] answer = new int[arr.length -1]; 
            for(int i = 0; i < arr.length - 1; i++){
                answer[i] = list.get(i);
            }
            return answer;
        }   
        
    }
}