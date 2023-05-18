import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 파티의 첫번째 친구 기준으로 유니온파인드해서 확인하기
 */
public class Main {
    static int N, M, res;
    static int[] parent, trueHuman;
    static ArrayList<Integer>[] partyHuman;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        N = Integer.parseInt(NM[0]);
        M = Integer.parseInt(NM[1]);
        String[] inputTrue = br.readLine().split(" ");
        int trueNum = Integer.parseInt(inputTrue[0]);
        trueHuman = new int[trueNum];
        for(int i = 0; i < trueNum; i++){
            trueHuman[i] = Integer.parseInt(inputTrue[i+1]);
        }
        partyHuman = new ArrayList[M];
        parent = new int[N+1];
        for(int i = 1; i <= N; i++){
            parent[i] = i;
        }
        for(int i = 0; i < M; i++){
            partyHuman[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < M; i++){
            String[] inputParty = br.readLine().split(" ");
            int partyNum = Integer.parseInt(inputParty[0]);
            int firstNum = Integer.parseInt(inputParty[1]);
            partyHuman[i].add(firstNum);
            for(int j = 1; j < partyNum; j++){
                int secondNum = Integer.parseInt(inputParty[j+1]);
                union(firstNum, secondNum);
            }
        }
        res = 0;
        for(int i = 0; i < M; i++){
            boolean possible = true;
            int cur = partyHuman[i].get(0);
            for(int j = 0; j < trueNum; j++){
                if(find(trueHuman[j]) == find(cur)){
                    possible = false;
                }
            }
            if(possible) res++;
        }
        System.out.println(res);
    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            parent[b] = a;
        }
    }
    public static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}
