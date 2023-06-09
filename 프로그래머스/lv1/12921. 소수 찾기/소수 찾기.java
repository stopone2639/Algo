class Solution {
    public int solution(int n) {
        boolean[] prime = new boolean[n+1];
        prime[0] = true;
        prime[1] = true;
        for(int i =2; i <= Math.sqrt(n); i++){
            for(int j = i*i; j <= n; j+=i){
                prime[j] = true;
            }
        }
        int answer = 0;
        for(int i = 0; i <= n; i++){
            if(!prime[i]){
                answer++;
            }    
        }
        return answer;
    }
}