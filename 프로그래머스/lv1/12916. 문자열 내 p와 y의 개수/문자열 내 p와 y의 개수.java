class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        int pCnt = s.length() - s.replace("p", "").length();
        int yCnt = s.length() - s.replace("y", "").length();
        return pCnt - yCnt == 0;
    }
}