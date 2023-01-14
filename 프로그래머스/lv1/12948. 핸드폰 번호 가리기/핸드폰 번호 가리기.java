class Solution {
    public String solution(String phone_number) {
        int frontSize = phone_number.length() - 4;
        String front = star(frontSize);
        String answer = front + phone_number.substring(phone_number.length() - 4, phone_number.length()); 
        return answer;
    }
    public String star(int i){
        return "*".repeat(i);
    }
}