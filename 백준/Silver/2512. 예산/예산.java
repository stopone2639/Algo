import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * total : 총 예산
 * max : 인풋 예산 중 최대 값
 * 이진 탐색 범위는 0부터 max까지
 */
public class Main {
    static int[] arr;
    static int total, N, max;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        total = Integer.parseInt(br.readLine());
        arr = new int[N];
        max = 0;
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(str[i]);
            max = Math.max(max, arr[i]);
        }
        int res = bs(0, max, total);
        System.out.println(res);
    }
    public static int bs(int start, int end, int total){
        int answer = 0;
        while(start <= end){
            int mid = (start + end)/2;
            int sum = 0;
            for(int i = 0; i < arr.length; i++){
                if(arr[i] <= mid){
                    sum += arr[i];
                } else{
                    sum += mid;
                }
            }
            if(sum <= total){
                answer = mid;
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        return answer;
    }
}
