import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * set.contains 이용
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        for(int tc = 0; tc < Tc; tc++){
            HashSet<Integer> set = new HashSet<>();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i =0; i < N; i++){
                int num = Integer.parseInt(st.nextToken());
                set.add(num);
            }
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i <M; i++){
                int num = Integer.parseInt(st.nextToken());
                if(set.contains(num)){
                    sb.append("1\n");
                } else{
                    sb.append("0\n");
                }
            }
        }
        System.out.println(sb);
    }

}
