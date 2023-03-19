import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 정렬 이용 배열 정렬
 * 투 포인터 이용
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(arr);
        int start = 0;
        int end = N-1;
        int cnt = 0;
        while(start < end){
            if(arr[start] + arr[end] == M){ //같을 때
                cnt++;
                start++;
                end--;
            } else if(arr[start] + arr[end] > M){ //클 때
                end--;
            } else{ //작을 때
                start++;
            }
        }
        System.out.println(cnt);
    }
}
