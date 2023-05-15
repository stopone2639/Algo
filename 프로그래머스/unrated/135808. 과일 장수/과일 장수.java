import java.util.Arrays;


class Solution {
    public static int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int maxBoxLength = score.length / m;
        int[] box = new int[maxBoxLength];
        int idx = 0;
        int min = 10;
        for (int i = score.length - 1; i >= m-1; i -= m) {
            for (int j = i; j > i - m; j--) {
                min = Math.min(min, score[j]);
            }
            box[idx++] = min * m;
        }

        return Arrays.stream(box).sum();
    }
}