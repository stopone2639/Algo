import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 유클리드 호제법으로 최대 공약수 구한뒤 두 수의 곱을 최대 공약수로 나누어서 최소 공배수를 구한다.
 * XOR를 이용한 교체 알고리즘으로 temp 없이 교체
 * 100만 * 100만 = 1조이므로 long으로
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Tc = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < Tc; tc++){
            String[] s = br.readLine().split(" ");
            long a = Long.parseLong(s[0]);
            long b = Long.parseLong(s[1]);
            if(a < b){
                a = a ^ b;
                b = a ^ b;
                a = a ^ b;
            }
            long gcd = hojebub(a, b);
            long answer = (a * b)/gcd;
            System.out.println(answer);
        }
    }
    public static long hojebub(long a, long b){
        while(b != 0){
            long n = a%b;
            a = b;
            b = n;
        }
        return a;
    }
}
