import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 위상 정렬(답이 여러개 나올 수 있으므로 유추 가능)
 */
public class Main{
    static int N, M;
    static int[] inCome, res;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        inCome = new int[N+1];
        res = new int[N];
        for(int i = 1; i <= N; i++){
            arr[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < M; i++){
            String[] AB = br.readLine().split(" ");
            int A = Integer.parseInt(AB[0]);
            int B = Integer.parseInt(AB[1]);
            arr[A].add(B);
            inCome[B] += 1;
        }
        Queue<Integer> qu = new LinkedList<>();
        for(int i = 1; i<= N; i++){
            if(inCome[i] == 0){
                qu.add(i);
            }
        }
        int cnt = 0;
        while(!qu.isEmpty()){
            int cur = qu.poll();
            res[cnt] = cur;
            cnt++;
            for(int num : arr[cur]){
                inCome[num] -= 1;
                if(inCome[num] == 0){
                    qu.offer(num);
                }
            }
        }
        for(int i = 0; i <N; i++){
            sb.append(res[i] + " ");
        }
        System.out.println(sb.toString());
    }
}
