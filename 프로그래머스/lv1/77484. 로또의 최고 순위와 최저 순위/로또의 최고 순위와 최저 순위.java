class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int[] match = {6,5,4,3,2};
        int max = 0; 
        int min = 0;
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0) max++;
            for(int j = 0; j < win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    max++;
                    min++;
                }
            }
        }
        answer[0] = 6;
        answer[1] = 6;
        for(int i = 0; i < match.length; i++){
            if(match[i] == max){
                answer[0] = i+1;
            }
            if(match[i] == min){
                answer[1] = i+1;
            }
        }
        return answer;
    }
}