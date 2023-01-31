/**
* 맵에 키(숫자), 밸류(갯수) 담기
* 밸류 꺼내서 큰 순으로 정렬 
* 큰 수부터 빼면서 answer++ 음수가 되면 브레이크
*/
import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : tangerine){
           if(map.containsKey(num)){
               map.put(num, map.get(num) + 1);
           } else{
               map.put(num, 1);
           }            
        }
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        int answer = 0;
        for(Integer i : list){
            k -= i;
            answer++;
            if(k <= 0){
                break;
            }
        }
        return answer;
    }
}