import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 선택 정렬로 구현
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("");
        int[] arr = new int[str.length];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        for(int i = 0; i < arr.length - 1; i++){
            int max = i;
            for(int j = i+1; j < arr.length; j++){
                if(arr[j] > arr[max]){
                    max = j;
                }
            }
            if(arr[i] < arr[max]){
                int temp = arr[i];
                arr[i] = arr[max];
                arr[max] = temp;
            }
        }
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]);
        }
        System.out.println(sb);
    }
}
