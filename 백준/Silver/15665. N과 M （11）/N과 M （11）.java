import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백트래킹 배열 입력
 * 중복 순열
 * 중복 된 값 있으면 중복 출력 x
 */
public class Main {
    static int N, M;
    static int[] inputArr, arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        inputArr = new int[N];
        arr = new int[M];
        String[] input2 = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            inputArr[i] = Integer.parseInt(input2[i]);
        }
        Arrays.sort(inputArr);
        DFS(0);
        System.out.println(sb.toString());
    }
    public static void DFS(int r){
        if(r == M){
            for(int i = 0; i < M; i++){
                sb.append(arr[i] + " ");
            }
            sb.append("\n");
            return;
        }
        int before = 0;
        for(int i = 0; i < N; i++){
            if(before != inputArr[i]){
                arr[r] = inputArr[i];
                before = inputArr[i];
                DFS(r+1);
            }
        }
    }
}
