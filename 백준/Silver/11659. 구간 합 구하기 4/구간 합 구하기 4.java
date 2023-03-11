import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 구간합 이용 배열에 그 인덱스까지의 합을 저장
 * 배열 J 값에서 배열 I-1 값을 빼면 구간합이 나옴
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        String[] nums = br.readLine().split(" ");
        int[] arr = new int[N + 1];
        int sum = 0;
        for(int i = 1; i <= N; i++){
            sum += Integer.parseInt(nums[i - 1]);
            arr[i] = sum;
        }
        for(int i = 0; i < M; i++){
            String[] IJ = br.readLine().split(" ");
            int I = Integer.parseInt(IJ[0]);
            int J = Integer.parseInt(IJ[1]);
            int res = arr[J] - arr[I-1];
            System.out.println(res);
        }
    }
}
