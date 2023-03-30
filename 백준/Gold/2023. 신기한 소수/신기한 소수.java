import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * DFS 
 * 1의 자리 소수는 2,3,5,7
 * 소수가 아니면 가지치기
 * 2자리 수부터는 일의자리가 홀수여야됨
 */
public class Main {
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
    }
    static void dfs(int number, int jari){
        if(jari == N){
            if(isPrime(number)){
                System.out.println(number);
            }
            return;
        }
        for(int i = 1; i < 10; i++){
            if(i % 2 == 0) continue;
            if(isPrime(number * 10 + i)){
                dfs(number * 10 + i, jari + 1);
            }
        }
    }
    static boolean isPrime(int num){
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
