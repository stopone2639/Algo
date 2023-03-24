import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 버블 소트는 한번 수행 시마다 맨 마지막부터 하나씩 결정 됨, 그래서 왼쪽으로 한칸 씩 밀림 이걸 이용해서 왼쪽으로 인덱스가 밀린 값 중 최대값에 +1을 하면 changed가 false일 때 값을 구할 수 있음
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Num[] arr = new Num[N];
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = new Num(num, i);
        }
        Arrays.sort(arr);
        int max = 0;
        for(int i = 0; i<N; i++){
            Num num = arr[i];
            max = Math.max(num.index - i, max);
        }
        int res = max + 1;
        System.out.println(res);
    }
    public static class Num implements Comparable<Num>{
        int num;
        int index;
        public Num(int num, int index){
            this.num = num;
            this.index = index;
        }
        public int compareTo(Num o){
            return this.num - o.num;
        }
    }
}
