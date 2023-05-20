import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 위상 정렬
 */
public class Main {
    static int[] inCome, def, need;
    static int N;
    static ArrayList<Integer>[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new ArrayList[N+1];
        inCome = new int[N+1];
        def = new int[N+1];
        need = new int[N+1];
        for(int i = 1; i<= N; i++){
            arr[i] = new ArrayList<Integer>();
        }
        for(int i = 1; i <= N; i++){
            String[] input = br.readLine().split(" ");
            int time = Integer.parseInt(input[0]);
            def[i] = time;
            for(int j = 1; j < input.length; j++){
                int num = Integer.parseInt(input[j]);
                if(num != -1){
                    arr[num].add(i);
                    inCome[i] += 1;
                }
            }
        }
        Queue<Integer> qu = new LinkedList<>();
        for(int i = 1; i <= N; i++){
            if(inCome[i] == 0){
                qu.add(i);
            }
        }
        while(!qu.isEmpty()){
            int cur = qu.poll();
            for(int num : arr[cur]){
                need[num] = Math.max(need[num], need[cur] + def[cur]);
                inCome[num] -= 1;
                if(inCome[num] == 0){
                    qu.add(num);
                }
            }
        }
        for(int i = 1; i <=N; i++){
            sb.append(need[i]+def[i]+ "\n");
        }
        System.out.println(sb.toString());
    }
}
