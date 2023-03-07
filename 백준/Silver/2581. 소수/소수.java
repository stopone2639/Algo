import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 10000까지 에라토스테네스의 체 이용 소수 판별
 * N부터 M까지 줄어드며 반복문 min에 가장 작은 소수가 들어가게 하기 위해
 * 소수 관련 문제에서 1을 처리해주는 게 중요
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] check = new boolean[10001];
        check[1] = true;
        for(int i = 2; i <= Math.sqrt(10000); i++){
            if(!check[i]){
                int mul = 2;
                while(i * mul <= 10000){
                    if(!check[i*mul]){
                        check[i*mul] = true;
                    }
                    mul += 1;
                }
            }
        }
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = -1;
        for(int i = N; i >= M; i--){
            if(!check[i]){
                sum += i;
                min = i;
            }
        }
        if(min == -1){
            System.out.println(-1);
        } else{
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
