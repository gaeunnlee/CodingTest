
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        int a = IntStream.range(0,num_list.length).reduce(1, (m, n) -> {
        	return m * num_list[n];
        });
        int b = (int) Math.pow(IntStream.range(0, num_list.length).map(i -> num_list[i]).sum(), 2);    
        
        return a > b ? 0 : 1;
    }
}