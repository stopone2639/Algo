import java.io.*;
import java.util.*;
/**
 * 들어 갈 수 있는지 확인 후 등수 찾기
 */
public class Main {
    public static void main(String[]args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int frontNum = 0; //앞에 있는 수
        int sameNum = 0; //같은 점수 가진 갯수
        if(N != 0){
            st = new StringTokenizer(br.readLine());
        }
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num > score){
                frontNum++;
            }
            if(num == score){
                frontNum++;
                sameNum++;
            }
        }
        if(frontNum >= P){
            System.out.println(-1);
        } else{
            System.out.println(frontNum - sameNum + 1);
        }
    }
}
