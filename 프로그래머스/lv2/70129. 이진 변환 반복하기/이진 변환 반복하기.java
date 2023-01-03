class Solution {
    public int[] solution(String s) {
        int zeroCnt = 0;
        int changeCnt = 0;
        while(!s.equals("1")){
            zeroCnt += s.length() - s.replace("0", "").length();
            s = s.replace("0", "");
            int leng = s.length();
            s = Integer.toString(leng, 2);
            changeCnt++;
        }
        int[] answer = {changeCnt, zeroCnt};
        return answer;
    }
}