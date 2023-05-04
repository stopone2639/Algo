import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] inputArr, arr;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        inputArr = new int[N];
        visit = new boolean[N];
        arr = new int[M];
        String[] inputStr = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            inputArr[i] = Integer.parseInt(inputStr[i]);
        }
        Arrays.sort(inputArr);
        DFS(0);
        System.out.println(sb.toString());
    }
    public static void DFS(int r){
        if(r == M){
            for(int i = 0; i < M; i++){
                sb.append(arr[i] +" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < N;i++){
            if(!visit[i]){
                arr[r] = inputArr[i];
                visit[i] = true;
                DFS(r+1);
                visit[i] = false;
            }
        }
    }
}
