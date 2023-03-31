import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.cert.TrustAnchor;
import java.util.ArrayList;

/**
 * DFS 이용
 * 깊이가 5가되면 boolean 값 true
 */
public class Main{
    static boolean res;
    static boolean[] visit;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);
        arr = new ArrayList[N];
        visit = new boolean[N];
        res = false;
        for(int i = 0; i < N; i++){
            arr[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < M; i++){
            String[] AB = br.readLine().split(" ");
            int A = Integer.parseInt(AB[0]);
            int B = Integer.parseInt(AB[1]);
            arr[A].add(B);
            arr[B].add(A);
        }
        for(int i = 0; i < N; i++){
            dfs(i, 1);
            if(res) break;
        }
        if(res){
            System.out.println(1);
        } else{
            System.out.println(0);
        }
    }
    static void dfs(int num, int depth){
        if(depth == 5 || res){
            res = true;
            return;
        }
        visit[num] = true;
        for(int i : arr[num]){
            if(!visit[i]){
                dfs(i, depth + 1);
            }
        }
        visit[num] = false;
    }
}
