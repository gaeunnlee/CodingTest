import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> stk = new ArrayList<Integer>();
        int i = 0;
        
        while ( i < arr.length ) {
        	if (stk.isEmpty()) {
            	stk.add(arr[i]);
            	i++;
            } else {
            	if (stk.get(stk.size()-1) >= arr[i]) {
            		stk.remove(stk.size()-1);
            	} else {
            		stk.add(arr[i]);
            		i++;
            	}
            }
        }
        
        return stk.stream().mapToInt(k -> k).toArray();
    }
}