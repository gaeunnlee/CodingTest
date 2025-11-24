import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> answer = new ArrayList<>();
        
        for (int[] interval: intervals) {
            IntStream.rangeClosed(interval[0], interval[1]).forEach(i -> answer.add(arr[i]));
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}