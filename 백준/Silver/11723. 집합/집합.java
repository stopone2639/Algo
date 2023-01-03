import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        sb = new StringBuilder();
        A = 0;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            String comp = st.nextToken();
            int num = 0;
            if(comp.equals("all") || comp.equals("empty")){
                num = 0;
            } else{
                num = Integer.parseInt(st.nextToken());
            }
            command(comp, num);
        }
        System.out.println(sb);
    }
    public static void command(String comp, int num){
        switch (comp){
            case "add":
                A |= (1<<(num-1));
                break;
            case "remove":
                A &= ~(1<<(num-1));
                break;
            case "check":
                if((A & (1<<(num-1))) > 0){
                    sb.append("1\n");
                } else{
                    sb.append("0\n");
                }
                break;
            case "toggle":
                if((A & (1<<(num-1))) > 0){
                    A &= ~(1<<(num-1));
                } else{
                    A |= (1<<(num-1));
                }
                break;
            case "all":
                A = (1<<20) - 1;
                break;
            case "empty":
                A = 0;
                break;
        }
    }
}
