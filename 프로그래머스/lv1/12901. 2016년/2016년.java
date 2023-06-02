class Solution {
    public String solution(int a, int b) {
        int[] months = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int total = 0;
        for(int i = 1; i < a; i++){
            total += months[i-1];
        }
        total += b - 1;
        return days[total % 7];
    }
}