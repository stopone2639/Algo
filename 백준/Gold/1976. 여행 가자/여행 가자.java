import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[] parent;
    static int[] route;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        parent = new int[N+1];
        route = new int[M];
        for(int i = 1; i <=N; i++){
            parent[i] = i;
        }
        for(int i = 1; i <= N; i++){
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++){
                int num = Integer.parseInt(input[j]);
                if(num == 1){
                    union(i, j+1);
                }
            }
        }
        String[] input2 = br.readLine().split(" ");
        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(input2[i]);
            route[i] = num;
        }
        boolean check = true;
        int num = find(route[0]);
        for(int i = 1; i < M; i++){
            if(num != find(route[i])){
                check = false;
            }
        }
        if(check){
            System.out.println("YES");
        } else{
            System.out.println("NO");
        }
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a < b){
            parent[b] = a;
        } else{
            parent[a] = b;
        }
    }
    public static int find(int a){
        if(parent[a] == a) return a;
        else{
            return parent[a] = find(parent[a]);
        }
    }
}
