import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * n의 범위가 1000까지라 에라토스테네스의 체로 1000까지 소수 여부 체크하고 입력한 숫자가 소수인지 체크
 * 1은 소수가 아니므로 true로 처리해서 지워주기
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] check = new boolean[1001];
        for(int i = 2; i <= Math.sqrt(1000); i++){
            if(!check[i]){
                int mul = 2;
                while(i * mul <= 1000){
                    check[i*mul] = true;
                    mul += 1;
                }
            }
        }
        check[1] = true;
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int cnt = 0;
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(s[i]);
            if(!check[num]){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
