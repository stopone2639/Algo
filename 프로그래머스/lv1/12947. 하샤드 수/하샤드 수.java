class Solution {
    public boolean solution(int x) {
        int sum = 0;
        int num = x;
        boolean answer = true;
        while(num!=0){
            sum += num%10;
            num /=10;
        }
        if(x%sum != 0){
            answer = false;
        } else{
            answer = true;
        }
        return answer;
    }
}