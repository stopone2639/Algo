import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 유클리드 호제법 이용
 * 합을 long 타입으로
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Tc = Integer.parseInt(br.readLine());
        for(int tc = 0; tc< Tc; tc++){
            long sum = 0;
            String[] s = br.readLine().split(" ");
            int N = Integer.parseInt(s[0]);
            int[] arr = new int[N];
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(s[i+1]);
            }
            for(int i = 0; i < arr.length - 1; i++){
                for(int j = i + 1; j < arr.length;j++){
                    int a = arr[i];
                    int b = arr[j];
                    if(a < b){
                        int tmp = a;
                        a = b;
                        b = tmp;
                    }
                    int gcd = 0;
                    gcd = hojebub(a, b);
                    sum += gcd;
                }
            }
            System.out.println(sum);
        }
    }
    public static int hojebub(int a, int b){
        while(b != 0){
            int n = a%b;
            a = b;
            b = n;
        }
        return a;
    }
}
