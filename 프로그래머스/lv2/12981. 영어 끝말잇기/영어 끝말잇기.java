import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        ArrayList<String> list = new ArrayList<>();
        list.add(words[0]);
        int[] answer = new int[2];
        for(int i = 1; i < words.length; i++){
            String last = list.get(i-1);
            char lastWord = last.charAt(last.length() -1);
            String cur = words[i];
            char curFirst = cur.charAt(0);
            if(list.contains(cur) || lastWord != curFirst){
                answer[0] = (i%n) + 1;
                answer[1] = (i/n) + 1;
                return answer;
            }
            list.add(words[i]);
        }
        return answer;
    }
}