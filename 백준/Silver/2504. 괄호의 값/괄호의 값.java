import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * (, [ : 스택에 넣고 mul에 2,3 곱해주기
 * ). ] : 스택에서 꺼내서 짝 확인하고 실패 하면 return 0, 앞에거 확인 후 자기 짝이면 숫자 역할 해야되므로 mul에서 2 or 3 나눠주고 mul * 2 or 3 해서 result에 더해주기
 */
public class Main {
    public static char[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        arr = s.toCharArray();

        int result = check();
        System.out.println(result);
    }
    public static int check(){
        int mul = 1;
        int result = 0;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == '('){
                stack.push('(');
                mul *= 2;
            } else if(arr[i] == '['){
                stack.push('[');
                mul *=3;
            } else if(arr[i] == ')'){
                if(stack.isEmpty() || stack.peek() != '('){
                    return 0;
                } else{
                    if(arr[i-1] == '('){
                        mul /= 2;
                        result += 2 * mul;
                        stack.pop();
                    } else{
                        mul /= 2;
                        stack.pop();
                    }
                }
            } else if(arr[i] == ']'){
                if(stack.isEmpty() || stack.peek() != '['){
                    return 0;
                } else{
                    if(arr[i-1] == '['){
                        mul /= 3;
                        result += 3 * mul;
                        stack.pop();
                    } else{
                        mul /=3;
                        stack.pop();
                    }
                }
            }
        }
        if(stack.isEmpty()){
            return result;
        }else {
            return 0;
        }
    }
}
