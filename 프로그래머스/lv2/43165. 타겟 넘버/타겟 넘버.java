class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, 0, 0, target);
        return answer;
    }
    public void dfs(int[] numbers, int depth, int sum, int target){
        if(depth == numbers.length){
            if(target == sum){
                answer += 1;
            }
            return;
        }
        dfs(numbers, depth + 1, sum + numbers[depth], target);
        dfs(numbers, depth + 1, sum - numbers[depth], target);
    }
}