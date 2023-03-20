import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 슬라이딩 윈도우 이용
 * A C G T 카운트가 입력 값보다 크면 res++
 */
public class Main {
    static int S, P;
    static int[] inCheck, strCheck;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = br.readLine().split(" ");
        S = Integer.parseInt(sp[0]);
        P = Integer.parseInt(sp[1]);
        inCheck = new int[4]; //0:A, 1:C, 2:G, 3:T
        strCheck = new int[4];//0:A, 1:C, 2:G, 3:T
        int res = 0;
        char[] inputStr = br.readLine().toCharArray();
        String[] inCheckStr = br.readLine().split(" ");
        for(int i = 0; i < inCheckStr.length; i++){
            inCheck[i] = Integer.parseInt(inCheckStr[i]);
        }
        for(int i = 0; i < P; i++){ //초기 str 넣기
            in(inputStr[i]);
        }
        if(check(inCheck, strCheck)) res++;
        for(int i = P; i < S; i++){
            int front = i - P;
            out(inputStr[front]);
            in(inputStr[i]);
            if(check(inCheck, strCheck)) res++;
        }
        System.out.println(res);
    }
    public static void in(char c){
        switch (c){
            case 'A':
                strCheck[0] += 1;
                break;
            case 'C':
                strCheck[1] += 1;
                break;
            case 'G':
                strCheck[2] += 1;
                break;
            case 'T':
                strCheck[3] += 1;
                break;
        }
    }
    public static void out(char c){
        switch (c){
            case 'A':
                strCheck[0] -= 1;
                break;
            case 'C':
                strCheck[1] -= 1;
                break;
            case 'G':
                strCheck[2] -= 1;
                break;
            case 'T':
                strCheck[3] -= 1;
                break;
        }
    }
    public static boolean check(int[] inCheck, int[] strCheck){
        for(int i = 0; i < 4; i++){
            if(inCheck[i] > strCheck[i]){
                return false;
            }
        }
        return true;
    }
}
