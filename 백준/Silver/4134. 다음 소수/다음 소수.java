import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 소수 판별 알고리즘, N부터 증가하며 while문 소수면 출력 후 break;
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Tc = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < Tc; tc++){
            long N = Long.parseLong(br.readLine());
            long num = N;
            while(true){
                if(check(num)){
                    System.out.println(num);
                    break;
                }
                num++;
            }
        }
    }
    public static boolean check(long num){
        if(num == 1 || num == 0){
            return false;
        }
        for(long i = 2; i <= Math.sqrt(num); i++){
            if(num%i == 0){
                return false;
            }
        }
        return true;
    }
}
