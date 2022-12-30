class Solution {
    public String solution(String s) {
        String answer = "";
        String[] strArr = s.split(" ");
        for(String str : strArr){
            if(str.length() == 0){
                answer += " ";
            } else{
                String change = str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase();
                answer += change + " ";
            }        
        }
        if(s.substring(s.length() - 1, s.length()).equals(" ")){
            return answer;
        }
        return answer.substring(0, answer.length() - 1);
    }
}