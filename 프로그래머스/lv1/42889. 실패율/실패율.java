import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double result[]=new double[N];
        int i,j=0;
        int gd_cnt=0;
        int all_cnt=0;

        for(i=0;i<N;i++){
        gd_cnt=0;
        all_cnt=0;
        answer[i]=i+1;
            for(j=0;j<stages.length;j++){
                if( i==(stages[j]-1) )
                gd_cnt+=1;
                if( i<=(stages[j]-1) )
                all_cnt+=1;                   
            }
        result[i]=(double)gd_cnt/all_cnt;
        }

        for(i=N-1;i>=1;i--){
            for(j=N-1;j>=(N-i);j--){
                if( result[j-1]<result[j] ){
                    double temp=result[j-1];
                    result[j-1]=result[j];
                    result[j]=temp;
                    int temp2=answer[j-1];
                    answer[j-1]=answer[j];
                    answer[j]=temp2;
                }
            }
        }        
        return answer;
    }
}