import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 *  입력 개수 미정일 때 자바 버퍼드 리더로 받기, 맵 키로 정렬하기 리스트에 keySet넣고 컬렉션즈 소트
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Double> map = new HashMap<>();
        double cnt = 0d;
        String str;
        while((str = br.readLine()) != null){
            if(map.containsKey(str)){
                map.put(str, map.get(str) + 1d);
            } else{
                map.put(str, 1d);
            }
            cnt++;
        }
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);
        for(String key : keySet){
            double per = (map.get(key)/cnt) * 100;
            System.out.printf("%s %.4f\n", key ,per);
        }
    }
}
