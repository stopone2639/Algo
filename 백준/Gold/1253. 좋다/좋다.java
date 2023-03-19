import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 정렬 후 for문 반복 투 포인터
 * 합이 커질 수 있으므로 long 배열
 * start 값이나 end 값이 index 값과 같으면 올려주거나 내려줘서 넘어가는 연산이 필요
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        String[] s = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            arr[i] = Long.parseLong(s[i]);
        }
        Arrays.sort(arr);
        int cnt = 0;
        for (int i = 0; i < N; i++){
            long find = arr[i];
            int start = 0;
            int end = N-1;
            while (start != end){
                if(arr[start] + arr[end] == find){ // 같을 때
                    if(start != i && end != i){
                        cnt++;
                        break;
                    }else if(start == i){
                        start++;
                    } else if(end == i){
                        end--;
                    }
                } else if(arr[start] + arr[end] > find){//크면
                    end--;
                } else { //작으면
                    start++;
                }
            }
        }
        System.out.println(cnt);
    }
}
