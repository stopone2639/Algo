import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 객체를 절대값, 기본값으로 정의, PQ에 넣어서 자동 정렬, compareTo 구현시 언더플로우, 오버플로우 발생 가능한지 체크해서 구현하기
 */
public class Main {
    public static class Num implements Comparable<Num>{
        public int absVal; //절대값
        public int defVal; //기본값
        Num(int absVal, int defVal){
            this.absVal = absVal;
            this.defVal = defVal;
        }
        @Override
        public int compareTo(Num o) {
            if(this.absVal > o.absVal){
                return 1;
            } else if(this.absVal == o.absVal){
                if(this.defVal > o.defVal){
                    return 1;
                } else if(this.defVal == o.defVal){
                    return 0;
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Num> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num != 0){
                if(num > 0){
                    pq.add(new Num(num, num));
                } else{
                    pq.add(new Num(-num, num));
                }
            } else{
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                } else{
                    Num n = pq.poll();
                    sb.append(n.defVal).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
