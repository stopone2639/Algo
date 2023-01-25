import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
/**
 * set 이용, set contains로 값 확인
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        int cnt = 0;
        for(int i = 0; i < N; i++){
            set.add(br.readLine());
        }
        for(int i = 0; i<M; i++){
            String s = br.readLine();
            if(set.contains(s)){
                cnt++;
            }
        }
        sb.append(cnt);
        System.out.println(cnt);
    }
}
