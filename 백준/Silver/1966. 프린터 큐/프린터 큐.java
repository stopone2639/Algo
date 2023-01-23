import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Printer{
        public int imp;
        public int index;
        public Printer(int imp, int index){
            this.imp = imp;
            this.index = index;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int Tc = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < Tc; tc++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            Queue<Printer> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                int impo = Integer.parseInt(st.nextToken());
                queue.offer(new Printer(impo, i));
            }
            int rank = 0;
            while(true){
                Printer pr = queue.poll();
                int imp = pr.imp;
                int index = pr.index;
                boolean check = true;
                Iterator<Printer> iter = queue.iterator();
                while(iter.hasNext()){
                    Printer pr2 = iter.next();
                    if(pr2.imp > imp){
                        queue.offer(pr);
                        check = false;
                        break;
                    }
                }
                if(check){
                    if(index == idx){
                        rank++;
                        sb.append(rank).append("\n");
                        break;
                    } else{
                        rank++;
                    }
                }
            }
        }
        System.out.println(sb);
    }

}
