import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 스택 이용
 * pop 해야하는 숫자가 num보다 크면 그 수까지 push하고 꺼내기
 * pop 할 숫자보다 num이 크고 stack에서 꺼낸 숫자가 더 크면 NO 출력
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 1;
        for(int i = 0; i < N; i++){
            int popNum = Integer.parseInt(br.readLine());
            if(popNum >= num){
                while(num <= popNum){
                    stack.push(num);
                    sb.append("+\n");
                    num++;
                }
                stack.pop();
                sb.append("-\n");
            } else{
                if(stack.pop() == popNum){
                    sb.append("-\n");
                } else{
                    sb = new StringBuilder();
                    sb.append("NO");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
