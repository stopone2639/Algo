import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 버블정렬로 구현
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i< N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0 ; i < N-1; i++){
            for(int j = 0; j < N - 1 - i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for (int i =0; i < N; i++){
            System.out.println(arr[i]);
        }
    }
}
