import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int start = Math.max(0, n - 1);
        if (start >= num_list.length) return new int[0];
        return Arrays.copyOfRange(num_list, start, num_list.length);
    }
}