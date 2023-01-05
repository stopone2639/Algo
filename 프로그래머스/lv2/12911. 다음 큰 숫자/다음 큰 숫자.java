class Solution {
    public int solution(int n) {
        int answer = 0;
        String strN = Integer.toString(n, 2);
        int oneCntN = strN.length() - strN.replace("1", "").length();
        while(true){
            ++n;
            String strNum = Integer.toString(n, 2);
            int oneCntNum = strNum.length() - strNum.replace("1", "").length();
            if(oneCntN == oneCntNum){
                answer = n;
                break;
            }
        }
        return answer;
    }
}