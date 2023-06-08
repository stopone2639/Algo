class Solution {
    public int[] solution(int[] answers) {
        int[][] jik = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
        int[] res = new int[3];
        for(int i = 0; i < answers.length; i++){
            int num1 = jik[0][i%5];
            int num2 = jik[1][i%8];
            int num3 = jik[2][i%10];
            if(num1 == answers[i]){
                res[0] += 1;
            } 
            if(num2 == answers[i]){
                res[1] +=1;
            } 
            if(num3 == answers[i]){
                res[2] +=1;
            }
        }
       
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < res.length; i++){
            if(max <= res[i]){
                max = res[i];
            }
        }
        int cnt = 0;
        for(int i = 0; i< res.length; i++){
            if(res[i] == max){
                cnt++;
            }    
        }
        int[] answer = new int[cnt];
        int a = 0;
        for(int i = 0; i < res.length; i++){
            if(res[i] == max){
                answer[a] = i + 1;
                a++;
            }
        }
        return answer;
    }
}