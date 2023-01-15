import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String comp = st.nextToken();
            switch (comp){
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    stack.push(num);
                    break;
                case "pop":
                    if(stack.empty()){
                        sb.append(-1).append("\n");
                    } else{
                        int popNum = stack.pop();
                        sb.append(popNum).append("\n");
                    }
                    break;
                case "size":
                    int size = stack.size();
                    sb.append(size).append("\n");
                    break;
                case "empty":
                    if(stack.empty()){
                        sb.append(1).append("\n");
                    } else{
                        sb.append(0).append("\n");
                    }
                    break;
                case "top":
                    if(stack.empty()){
                        sb.append(-1).append("\n");
                    } else{
                        int topNum = stack.peek();
                        sb.append(topNum).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}
