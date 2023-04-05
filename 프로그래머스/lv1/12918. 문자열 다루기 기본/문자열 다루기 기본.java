class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        if((s.length() == 4 || s.length() == 6) && check(s)){
            answer = true;
        }
        return answer;
    }
    public boolean check(String str){
        try{
            Integer.parseInt(str);
            return true;
        } catch(Exception e){
            return false;
        }
    }
}