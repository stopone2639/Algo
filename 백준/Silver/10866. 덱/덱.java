import javax.swing.plaf.DesktopIconUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        for(int i =0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String comp = st.nextToken();
            switch (comp){
                case "push_front":
                    int frontN = Integer.parseInt(st.nextToken());
                    deque.offerFirst(frontN);
                    break;
                case "push_back":
                    int backN = Integer.parseInt(st.nextToken());
                    deque.offerLast(backN);
                    break;
                case "pop_front":
                    if(deque.isEmpty()){
                        sb.append("-1\n");
                    } else{
                        sb.append(deque.pollFirst()).append("\n");
                    }
                    break;
                case "pop_back":
                    if(deque.isEmpty()){
                        sb.append("-1\n");
                    } else{
                        sb.append(deque.pollLast()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
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
                        sb.append(deque.peekFirst()).append("\n");
                    }
                    break;
                case "back":
                    if(deque.isEmpty()){
                        sb.append("-1\n");
                    } else{
                        sb.append(deque.peekLast()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
