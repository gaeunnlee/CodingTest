import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        
        Arrays.stream(num_list).forEach(v -> {
        	if (v % 2==0) {
        		even.append(v);
        	} else {
        		odd.append(v);
        	}
        	
        });
        
        return Integer.parseInt(odd.toString()) + Integer.parseInt(even.toString());

    }
}