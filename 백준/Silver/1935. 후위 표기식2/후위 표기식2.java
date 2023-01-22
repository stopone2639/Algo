import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int aNum = 65;
        HashMap<Character, Double> map = new HashMap<>();
        Stack<Double> stack = new Stack<>();
        for(int i = 0; i < N; i++){
            char aChar = (char)aNum;
            map.put(aChar, Double.parseDouble(br.readLine()));
            aNum++;
        }
        char[] arr = s.toCharArray();
        double a = 0;
        double b = 0;
        for(int i =0; i < arr.length; i++){
            char c = arr[i];
            switch (c){
                case '+':
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a+b);
                    break;
                case '-':
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a-b);
                    break;
                case '/':
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a/b);
                    break;
                case '*':
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a*b);
                    break;
                default:
                    double num = map.get(c);
                    stack.push(num);
                    break;
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
