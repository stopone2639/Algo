import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String comp = st.nextToken();
            switch (comp){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    deque.add(num);
                    break;
                case "pop":
                    if(deque.isEmpty()){
                        sb.append("-1\n");
                    } else{
                        sb.append(deque.poll() + "\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size()+"\n");
                    break;
                case "empty":
                    if(deque.isEmpty()){
                        sb.append("1\n");
                    } else{
                        sb.append("0\n");
                    }
                    break;
                case "front":
                    if(deque.isEmpty()){
                        sb.append("-1\n");
                    } else{
                        sb.append(deque.peek()+ "\n");
                    }
                    break;
                case "back":
                    if(deque.isEmpty()){
                        sb.append("-1\n");
                    } else{
                        sb.append(deque.peekLast()+ "\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
