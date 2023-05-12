import java.util.*;
class Solution {
    static boolean[] visit;
    static int max;
    static int[] res;
    static ArrayList<Integer>[] list;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        visit = new boolean[n+1];
        list = new ArrayList[n+1];
        res = new int[n+1];
        for(int i = 0; i < n+1; i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < edge.length; i++){
            int a = edge[i][0];
            int b = edge[i][1];
            list[a].add(b);
            list[b].add(a);
        }
        max = Integer.MIN_VALUE;
        BFS();
        for(int i = 1; i < n+1; i++){
            if(res[i] == max){
                answer++;
            }
        }
        return answer;
    }
    public void BFS(){
        Queue<Integer> qu = new LinkedList<>();
        qu.add(1);
        res[1] = 0;
        visit[1] = true;
        while(!qu.isEmpty()){
            int cur = qu.poll();
            for(int num : list[cur]){
                if(!visit[num]){
                    res[num] = res[cur] + 1;
                    visit[num] = true;
                    qu.add(num);
                    max = Math.max(max, res[num]);
                }
            }
        }
    }
}