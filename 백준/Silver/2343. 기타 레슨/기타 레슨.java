import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 이진 탐색 이용
 * 이진 탐색 범위는 강의 길이 중 최대값 ~ 강의 전부의 합 시간까지
 * 합해서 mid 값이 넘어가면 cnt++ 해주고 cnt가 M보다 크면 블루레이 크기를 키워주고 작으면 블루레이 크기를 줄이기
 * start가 end보다 커졌을 때 start 값이 end + 1이 되고 이 값은 블루레이 크기 중 최소값
 * why? -> end + 1은 이전 mid 값이고 이 값이 블루레이 크기를 만족했기 때문에 end 값을 mid - 1로 했기 때문에 보장됨
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        int[] arr = new int[N];
        int start = 0;
        int end = 0;
        String[] str = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str[i]);
            if(arr[i] > start){
                start = arr[i];
            }
            end += arr[i];
        }
        while(start <= end){
            int mid = (start+end)/2;
            int cnt = 0;
            int sum = 0;
            for(int i = 0; i < N; i++){
                if(sum + arr[i] > mid){
                    cnt++;
                    sum = 0;
                }
                sum += arr[i];
            }
            if(sum != 0) cnt++;
            if(cnt > M){
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        System.out.println(start);
    }
}
