import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i =0; i < N; i++){
            String s = br.readLine();
            String[] arr = s.split("");
            boolean check = checkStack(arr);
            if(check) {
                sb.append("YES\n");
            } else{
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

    public static boolean checkStack(String[] arr){
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i].equals("(")){
                stack.push('(');
            } else{
                if(stack.empty()){
                    return false;
                } else{
                    stack.pop();
                }
            }
        }
        if(stack.empty()) {
            return true;
        } else{
            return false;
        }
    }
}
