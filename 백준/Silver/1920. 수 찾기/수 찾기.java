import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 정렬 후 이진 탐색
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        String[] str = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        String[] str2 = br.readLine().split(" ");
        for (int i = 0; i < M; i++){
            int num = Integer.parseInt(str2[i]);
            int start = 0;
            int end = N-1;
            boolean check = false;
            while(start <= end){
                int mid = (start + end)/2;
                if(arr[mid] > num){
                    end = mid - 1;
                } else if(arr[mid] < num){
                    start = mid + 1;
                } else{
                    check = true;
                    break;
                }
            }
            if(check){
                System.out.println(1);
            } else{
                System.out.println(0);
            }
        }
    }

}
