import java.util.*;
class Solution {
    static int[][] res;
    static int[][] dir = {{1,0}, {-1, 0}, {0,1}, {0,-1}};
    static boolean[][] visit;
    static int N;
    static int M;
    public int solution(int[][] maps) {
        int answer = 0;
        N = maps.length;
        M = maps[0].length;
        res = new int[N][M];
        visit = new boolean[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                res[i][j] = -1;
            }
        }
        bfs(0,0,maps);
        answer = res[N-1][M-1];
        return answer;
    }
    public class Point{
        int r, c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public void bfs(int r, int c, int[][] maps){
        Queue<Point> qu = new LinkedList<>();
        qu.add(new Point(r, c));
        res[r][c] = 1;
        visit[r][c] = true;
        while(!qu.isEmpty()){
            Point cur = qu.poll();
            for(int i = 0; i < 4; i++){
                int nr = cur.r + dir[i][0];
                int nc = cur.c + dir[i][1];
                if(checkArea(nr, nc) && !visit[nr][nc] && maps[nr][nc] == 1){
                    qu.add(new Point(nr, nc));
                    visit[nr][nc] = true;
                    res[nr][nc] = res[cur.r][cur.c] + 1;
                }
            }
        }
    }
    public boolean checkArea(int r, int c){
        return r >= 0 && r < N && c >= 0 && c < M; 
    }
}