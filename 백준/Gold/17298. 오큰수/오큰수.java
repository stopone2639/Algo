import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 스택 이용
 * 처음에 스택에 값 넣기
 * 다음 수들과 비교하며 오큰수를 찾으면 pop해서 결과 배열에 넣기
 * 스택에 남은 값의 인덱스에는 -1 넣기
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] res = new int[N];
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        String[] s = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        for(int i = 0; i < N; i++){
            if(i == 0){
                stack.push(0);
            } else{
                int num = arr[i];
                while (!stack.isEmpty()&& arr[stack.peek()] < num){
                    int index = stack.pop();
                    res[index] = num;
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            int index = stack.pop();
            res[index] = -1;
        }
        for (int i = 0; i < N; i++){
            sb.append(res[i] + " ");
        }
        System.out.println(sb);
    }
}
