import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] parent;
    static int n, m;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        sb = new StringBuilder();
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        parent = new int[n+1];
        for(int i = 1; i < n+1;i++){
            parent[i] = i;
        }
        for(int i = 0; i < m;i++){
            input = br.readLine().split(" ");
            int com = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);
            if(com == 1){
                check(a,b);
            } else{
                union(a,b);
            }
        }
        System.out.println(sb.toString());
    }
    public static void check(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b){
            sb.append("YES" + "\n");
        } else{
            sb.append("NO" + "\n");
        }
    }
    public static int union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return a;
        if(a < b) {
            parent[b] = a;
            return a;
        } else {
            parent[a] = b;
            return b;
        }
    }
    public static int find(int a){
        if(parent[a] == a) return a;
        parent[a] = find(parent[a]);
        return find(parent[a]);
    }
}
