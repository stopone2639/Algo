import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 맵 이용, 첫 글자 대문자이면 아스키 코드 65 이상 이용해서 숫자인지 영어인지 체크, 시간 초과 막기 위해 밸류로 키 찾기는 그냥 어레이 리스트에
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for(int i = 1; i <= N; i++){
            String input = br.readLine();
            map.put(input, i);
            list.add(input);
        }
        for(int i = 0; i < M; i++){
            String s = br.readLine();
            char c = s.charAt(0);
            int ascii = (int) c;
            if(c >= 65){
                Integer value = map.get(s);
                sb.append(value).append("\n");
            } else{
                int num = Integer.parseInt(s);
                sb.append(list.get(num - 1)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
