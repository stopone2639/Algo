import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb= new StringBuilder();
        StringTokenizer st = null;
        for(int tc = 1; tc <= N; tc++){
            st = new StringTokenizer(br.readLine());
            int Tc = Integer.parseInt(st.nextToken());
            int sum = 0;
            List<Integer> list = new ArrayList<>(20);
            for(int i = 0; i<20; i++){
                int num = Integer.parseInt(st.nextToken());
                if(i == 0) {
                    list.add(num);
                } else{
                    int back = 0;
                    boolean incheck = false;
                    for(int j = 0; j < list.size(); j++){
                        if(list.get(j) > num) {
                            back = list.size() - j;
                            list.add(j,num);
                            incheck = true;
                            break;
                        }
                    }
                    if(!incheck){
                        list.add(num);
                    }
                    sum += back;
                }
            }
            sb.append(Tc +" ").append(sum +"\n");
        }
        System.out.println(sb);
    }
}
