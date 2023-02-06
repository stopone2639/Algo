import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 규칙이 f1 = 1 f2 = 1 fn ~ = fn-1 + fn-2 인듯
 * 자리수 int는 10자리까지 가능 long 배열 사용
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N+1];
        for(int i = 1; i <= N; i++){
            if(i == 1 || i == 2){
                arr[i] = 1;
            } else{
                arr[i] = arr[i-1] + arr[i-2];
            }
        }
        System.out.println(arr[N]);
    }
}
