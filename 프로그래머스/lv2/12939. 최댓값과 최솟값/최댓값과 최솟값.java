class Solution {
    public String solution(String s) {
        String[] sNum = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(String str : sNum){
            int num = Integer.parseInt(str);
            if(num > max){
                max = num;
            } 
            if(num < min){
                min = num;
            }
        }
        String answer = min + " " + max;
        return answer;
    }
}