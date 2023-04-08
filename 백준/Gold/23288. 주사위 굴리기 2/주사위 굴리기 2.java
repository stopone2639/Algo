import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 시뮬레이션 
 * 점수 계산 BFS 이용
 * 주사위 클래스에 주사위 움직임, 회전,이동 방향 변경 구현
 */
public class Main {
	static int N, M, K, res;
	static int[][] arr;
	static int[][] dir = {{-1,0}, {0,1}, {1, 0}, {0,-1}}; //상우 하좌 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nmk = br.readLine().split(" ");
		N = Integer.parseInt(nmk[0]);
		M = Integer.parseInt(nmk[1]);
		K = Integer.parseInt(nmk[2]);
		res = 0;
		arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
			}
		}
		Dice dice = new Dice(0, 0, 1);
		for(int i = 0; i < K; i++) {
			int nr = dice.r + dir[dice.di][0];
			int nc = dice.c + dir[dice.di][1];
			if(areaCheck(nr, nc)) {
				dice.move();
			} else {
				dice.changeDi180();
				dice.move();
			}
			int num = arr[dice.r][dice.c];
			scoreCheck(dice.r, dice.c, num);
			int under = dice.num[5];
			if(under > num) {
				dice.changeDi90(true);
			} else if(under < num) {
				dice.changeDi90(false);
			}
			
		}
		System.out.println(res);
	}
	public static class Point{
		int r,c;
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void scoreCheck(int r, int c, int num) {
		boolean[][] visit = new boolean[N][M];
		Queue<Point> qu = new LinkedList<Point>();
		qu.add(new Point(r, c));
		int cnt = 1;
		visit[r][c] = true;
		while(!qu.isEmpty()) {
			Point cur = qu.poll();
			for(int i = 0; i < 4; i++) {
				int nr = cur.r + dir[i][0];
				int nc = cur.c + dir[i][1];
				if(areaCheck(nr, nc) && !visit[nr][nc] && arr[nr][nc] == num) {
					qu.add(new Point(nr, nc));
					visit[nr][nc] = true;
					cnt++;
				}
			}
		}
		res += cnt * num;
	}
	public static boolean areaCheck(int r, int c) {
		return r >=0 && r <N && c>=0 && c <M;
	}
	public static class Dice{
		int num[] = {2, 4, 1, 3, 5, 6}; //0: 앞, 1:왼 2:위 3:오 4:뒤 5:밑
		int r, c, di; //row col 방향
		public Dice(int r, int c,int di) {
			this.r = r;
			this.c = c;
			this.di = di;
		}
		public void move() {
			r = r + dir[di][0];
			c = c + dir[di][1];
			roration();
		}
		public void roration() { //d : 상 하 좌 우 
			int front = num[0];
			int left = num[1];
			int up = num[2];
			int right = num[3];
			int back = num[4];
			int under = num[5];
			if(di == 0) { //상(앞위뒤밑 -> 위뒤밑앞)
				num[0] = up;
				num[2] = back;
				num[4] = under;
				num[5] = front;
			} else if(di == 1) {//우 (왼위오밑 -> 밑왼위오)
				num[1] = under;
				num[2] = left;
				num[3] = up;
				num[5] = right;
			} else if(di == 2) { //하 (앞위뒤밑 -> 밑앞위뒤)
				num[0] = under;
				num[2] = front;
				num[4] = up;
				num[5] = back;
			} else if(di == 3) {//좌 (왼위오밑 -> 위오밑왼)
				num[1] = up;
				num[2] = right;
				num[3] = under;
				num[5] = left;
			}
		}
		public void changeDi180() {
			di = (di+2)%4;
		}
		public void changeDi90(boolean clock) {
			if(clock) { //시계 방향 90도
				di = (di+1)%4;
			} else {
				di = (di+3)%4;
			}
		}
	}
}
