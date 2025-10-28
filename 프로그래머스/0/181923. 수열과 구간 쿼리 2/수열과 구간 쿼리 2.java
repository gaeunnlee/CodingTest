import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
    List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < queries.length ; i++) {
        	int[] query = queries[i];	
        	int[] rangeArr = Arrays.copyOfRange(arr, query[0], query[1] + 1);
        	Arrays.sort(rangeArr);
        	
        	for (int j = 0; j < rangeArr.length; j++) {
        		if (query[2] < rangeArr[j]) {
        			answer.add(rangeArr[j]);
        			break;
        		}
        		
        		if (j == rangeArr.length - 1) {
        			answer.add(-1);
        		}
        	}        	
        }      
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}