
import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            boolean check = false;
            String input = br.readLine();
            if(input.equals("end")) break;
            check = check1(input);
            if(!check){
                System.out.printf("<%s> is not acceptable.\n", input);
                continue;
            }
            char[] cArr = input.toCharArray();
            check = check2(cArr);
            if(!check) {
                System.out.printf("<%s> is not acceptable.\n", input);
                continue;
            }
            check = check3(cArr);
            if(!check) {
                System.out.printf("<%s> is not acceptable.\n", input);
            } else{
                System.out.printf("<%s> is acceptable.\n", input);
            }
        }
    }
    public static boolean check1(String s){ //모음 여부 체크
        return s.contains("a") || s.contains("e") || s.contains("i")|| s.contains("o") ||s.contains("u");
    }

    public static boolean check2(char[] cArr){ //모음 자음 3개 연속 여부 체크
        if(cArr.length < 3) return true;
        for(int i = 1; i < cArr.length - 1; i++)  {
            if(check4(cArr[i])){
                if(check4(cArr[i-1]) && check4(cArr[i+1])){
                    return false;
                }
            } else{
                if(!check4(cArr[i-1]) && !check4(cArr[i+1])){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean check3(char[] cArr){ //같은 글자 연속 여부 체크 ee, oo는 허용
        if(cArr.length < 2) return true;
        for(int i = 1; i < cArr.length; i++){
            if(cArr[i] == cArr[i-1]){
                if(cArr[i] != 'e' && cArr[i] != 'o'){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean check4(char c){ //모음인지 자음인지 체크
         return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
