
class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        int i = 1;
        while(true){
            if(n == 1){
                return i;
            }
            if(a % 2 == 1){
                a += 1;
            }
            if(b % 2 == 1){
                b += 1; 
            }
            if(a == b){
                return i;
            } else{
                a /=2;
                b /=2;
                n /=2;
                i++;
            }
        }

    }
}