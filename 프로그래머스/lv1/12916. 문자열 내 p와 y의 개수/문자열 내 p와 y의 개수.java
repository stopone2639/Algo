class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String s2 = s.toLowerCase();
        int pCnt = s2.length() - s2.replace("p", "").length();
        int yCnt = s2.length() - s2.replace("y", "").length();
        if(pCnt - yCnt != 0){
            answer = false;
        }
        return answer;
    }
}