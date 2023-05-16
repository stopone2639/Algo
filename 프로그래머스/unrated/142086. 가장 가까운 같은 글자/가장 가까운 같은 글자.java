class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        char[] cArr = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            int num = check(i, s.charAt(i), cArr);
            answer[i] = num;
        }
        return answer;
    }
    public int check(int index, char c, char[] arr){
        int cnt = 0;
        for(int i = index - 1; i >= 0; i--){
            cnt++;
            if(arr[i] == c){
                return cnt;
            }
        }
        return -1;    
    }
}