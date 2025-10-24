import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int[] answer = Arrays.copyOf(num_list, num_list.length + 1);
		int[] k  = Arrays.copyOfRange(num_list, num_list.length - 2, num_list.length);
		answer[answer.length - 1] = k[1] > k[0] ? k[1] - k[0] : k[1] * 2;
        return answer;
    }
}