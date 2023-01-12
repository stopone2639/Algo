class Solution {
    public long solution(int a, int b) {
        long sum = 0;
        if(a == b){
            return a; 
        } else if(a > b){
            for(int i = b; i <= a; i++){
                sum += i;
            }
        } else if(b > a){
            for(int i = a; i <= b; i++){
                sum += i;
            }
        }
        return sum;
    }
}