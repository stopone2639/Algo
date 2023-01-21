import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
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
                        sb.append(-1).append("\n");
                    } else{
                        sb.append(deque.pop()).append("\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if(deque.isEmpty()) {
                        sb.append(1).append("\n");
                    } else{
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                    } else{
                        sb.append(deque.peek()).append("\n");
                    }
                    break;
                case "back":
                    if(deque.isEmpty()){
                        sb.append(-1).append("\n");
                    } else{
                        sb.append(deque.peekLast()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
