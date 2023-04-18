import java.util.*;
class Solution {
    static boolean[] visit;
    static LinkedList<Integer>[] arr;
    static int N;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        N = computers.length;
        arr = new LinkedList[N];
        visit = new boolean[N];
        for(int i = 0; i < N; i++){
            arr[i] = new LinkedList<Integer>();
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(computers[i][j] == 1 && i != j){
                    arr[i].add(j);
                }
            }
        }
        for(int i = 0; i < N; i++){
            if(!visit[i]){
                BFS(i);
                answer++;
            }
        }
        return answer;
    }
    public void BFS(int num){
        Queue<Integer> qu = new LinkedList<>();
        qu.add(num);
        visit[num] = true;
        while(!qu.isEmpty()){
            Integer cur = qu.poll();
            for(Integer i : arr[cur]){
                if(!visit[i]){
                    visit[i] = true;
                    qu.add(i);
                }
            }
        }
    }
}