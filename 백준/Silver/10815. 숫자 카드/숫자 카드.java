import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 상근이 카드 정렬 후 들어오는 숫자 이진 탐색 이용 값 유무 체크
 */
public class Main {
    static int N, M;
    static int[] sang, all;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        sang = new int[N];
        String[] sSang = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            sang[i] = Integer.parseInt(sSang[i]);
        }
        M = Integer.parseInt(br.readLine());
        all = new int[M];
        String[] sAll = br.readLine().split(" ");
        for(int i = 0; i< M; i++){
            all[i] = Integer.parseInt(sAll[i]);
        }
        Arrays.sort(sang);
        for(int num : all){
            boolean check = bs(0, sang.length - 1, num);
            if(check){
                sb.append(1 + " ");
            } else{
                sb.append(0 + " ");
            }
        }
        System.out.println(sb);
    }
    public static boolean bs(int start, int end, int num){
        while(start <= end){
            int mid = (start + end)/2;
            if(sang[mid] == num) return true;
            else if(sang[mid] > num) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }
}
