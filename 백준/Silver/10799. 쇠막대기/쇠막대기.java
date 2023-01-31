import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * ( 이거 이후 바로 ) 면 레이져 이후에 )가 나오면 막대기
 * 레이져면 스택에 있는 막대기 만큼 ++
 * 막대기면 막대기 갯수 1개 ++
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        int sum = 0;
        for(int i =0; i < arr.length; i++){
            if (arr[i] == '(') {
                stack.push(arr[i]);
            } else{
                if(arr[i-1] == '('){ //레이저일 때
                    stack.pop();
                    sum += stack.size();
                } else{
                    stack.pop();
                    sum += 1;
                }
            }
        }
        System.out.println(sum);
    }
}
