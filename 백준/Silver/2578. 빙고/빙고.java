import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 가로 체크 메서드, 세로 체크 메서드, 양 대각 체크 메서드해서 line수가 3이 넘으면 출력
 */
public class Main {
    static int N = 5;
    static int M = 5;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder();
        arr = new int[N][M]; //빙고 숫자 담을 배열
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        loop:
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int num = Integer.parseInt(st.nextToken());
                changeArr(num);
                int line = 0;
                line += checkX();
                line += checkY();
                line += checkCrossA();
                line += checkCrossB();
                if(line >= 3){
                    sb.append((i*5)+(j+1));
                    break loop;
                }
            }
        }
        System.out.println(sb);
    }
    public static void changeArr(int num){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == num){
                    arr[i][j] = -1;
                }
            }
        }
    }
    public static int checkX(){
        int line = 0;
        for(int i = 0; i < N; i++){
            int cnt = 0;
            for(int j = 0; j < M; j++){
                if(arr[i][j] == -1){
                    cnt++;
                }
                if(cnt == 5){
                    line++;
                }
            }
        }
        return line;
    }

    public static int checkY(){
        int line = 0;
        for(int i = 0; i < N; i++){
            int cnt = 0;
            for(int j = 0; j < M; j++){
                if(arr[j][i] == -1){
                    cnt++;
                }
                if(cnt == 5){
                    line++;
                }
            }
        }
        return line;
    }
    public static int checkCrossA(){
        for(int i = 0; i <N; i++){
            if(arr[i][i] != -1){
                return 0;
            }
        }
        return 1;
    }
    
    public static int checkCrossB(){
        for(int i = 0; i < N; i++){
            if(arr[i][N-1-i] != -1){
                return 0;
            }
        }
        return 1;
    }
}
