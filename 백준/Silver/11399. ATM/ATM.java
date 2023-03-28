import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 삽입 정렬로 구현
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sum = new int[N];
        String[] str = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        for(int i = 1; i < N; i++){
            int index = i;
            int num = arr[i];
            for(int j = i-1; j >= 0; j--){
                if(arr[j] < arr[i]){
                    index = j+1;
                    break;
                }
                if(j == 0){
                    index = 0;
                }
            }
            for(int j = i; j>index; j--){
                arr[j] = arr[j-1];
            }
            arr[index] = num;
        }
        sum[0] = arr[0];
        for(int i = 1; i < N; i++){
            sum[i] = sum[i-1] + arr[i];
        }
        int res = 0;
        for(int i = 0; i < N; i++){
            res += sum[i];
        }
        System.out.println(res);
    }
}
