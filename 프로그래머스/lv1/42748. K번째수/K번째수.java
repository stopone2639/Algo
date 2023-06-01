import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i = 0; i < commands.length; i++){
            int res = 0;
            int arr[] = Arrays.copyOfRange(array, commands[i][0] - 1 , commands[i][1]);
            Arrays.sort(arr);
            res = arr[commands[i][2] - 1];
            answer[i] = res;
        }
        return answer;
    }
}