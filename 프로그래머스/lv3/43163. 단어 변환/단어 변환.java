import java.util.*;
class Solution {
    static boolean[] visit;
    static int answer;
    public int solution(String begin, String target, String[] words) {
        answer = Integer.MAX_VALUE;
        boolean check = false;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(target)){
                check = true;
            }
        }
        if(!check){
            return 0;
        }
        visit = new boolean[words.length];
        DFS(begin, target, words, 0);
        answer = (answer == Integer.MAX_VALUE) ? 0 : answer;
        return answer;
    }
    public boolean checkStr(String str1, String str2){
        int dif = 0;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)) dif++;
        }
        if(dif == 1){
            return true;
        }
        return false;
    }
    public void DFS(String begin, String target, String[] words, int w){
        if(begin.equals(target)){
            answer = Math.min(answer, w);
            return;
        }
        for(int i = 0; i < words.length; i++){
            if(!visit[i] && checkStr(begin, words[i])){
                visit[i] = true;
                DFS(words[i], target, words, w+1);
                visit[i] = false;
            }
        }
    }
}