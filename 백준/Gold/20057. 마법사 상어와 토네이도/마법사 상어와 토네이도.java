import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * 시뮬레이션
 * 배열 움직임 dir, dis, 그리고 가중치 w를 이용하여 배열 회전 이동
 * 바람의 방향과 비율을 windRate, wind에 저장 wind 좌 하 우 상 순서
 */
public class Main {
	static int N, res, r, c;
	static int[][] arr;
	static int[][] dir = {{0,-1}, {1,0}, {0,1}, {-1, 0}};//좌 하 우 상
	static int[] dis = {1, 1, 2, 2};
	static int[] windRate = {1, 1, 2, 2, 7, 7, 10, 10, 5};
	static int[][] dirAlpha = {{0, -2}, {2, 0 }, {0, 2}, {-2, 0}}; //좌 하 우 상
	static int[][][] wind = {{{-1, 1, -2, 2, -1 , 1, -1, 1, 0},{0, 0, -1, -1, -1, -1, -2, -2, -3}}, {{0, 0, 1, 1, 1, 1, 2, 2, 3}, {-1, 1, -2, 2, -1 , 1, -1, 1, 0}}, {{-1, 1, -2, 2, -1 , 1, -1, 1, 0},{0, 0, 1, 1, 1, 1, 2, 2, 3}}, {{0, 0, -1, -1, -1, -1, -2, -2, -3},{-1, 1, -2, 2, -1 , 1, -1, 1, 0}}}; //dr dc 원래 위치 기준
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		res = 0;
		for(int i = 0; i < N; i++) {
			String[] line = br.readLine().split(" ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(line[j]);
			}
		}
		r = N/2;
		c = N/2;
		int w = 0;
		outer : 
		while(!(r == 0 && c == 0)) {
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < dis[i] + w; j++) {
					if(r == 0 && c == 0) {
						break outer;
					}
					move(i, r, c);
				}
			}
			w += 2;
		}
		System.out.println(res);
	}
	public static void move(int d, int row, int col) {
		int moveR = row + dir[d][0];
		int moveC = col + dir[d][1];
		int defaultSand = arr[moveR][moveC];
		int sand = arr[moveR][moveC]; //모래양
		for(int i = 0; i < 9; i++) {
			int nr = row + wind[d][0][i];
			int nc = col + wind[d][1][i];
			if(areaCheck(nr, nc)) {
				int moveSand = (defaultSand * windRate[i])/100;
				arr[nr][nc] += moveSand;
				sand -= moveSand;
			} else {
				int outSand = (defaultSand * windRate[i])/100;
				sand -= outSand;
				res += outSand;
			}
		}
		int alphaR = row + dirAlpha[d][0];
		int alphaC = col + dirAlpha[d][1];
		if(areaCheck(alphaR, alphaC)) {
			arr[alphaR][alphaC] += sand;
		} else {
			res += sand;
		}
		arr[moveR][moveC] = 0;
		r = moveR;
		c = moveC;
	}
	public static boolean areaCheck(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
}
