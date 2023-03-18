import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 투 포인터 이용
 * 자기자신 1가지수 미리 더해놓기 위해 cnt 1로
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int start = 1;
        int end = 1;
        int sum = 1;
        int cnt = 1;
        while(end != N){
            if(sum < N){
                end++;
                sum += end;
            } else if(sum > N){
                sum -= start;
                start++;
            } else{
                cnt++;
                end++;
                sum += end;
            }
        }
        System.out.println(cnt);
    }
}
