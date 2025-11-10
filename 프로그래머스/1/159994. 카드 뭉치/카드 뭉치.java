import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
            Queue<String> queue1 = new ArrayDeque<>(Arrays.asList(cards1));
	        Queue<String> queue2 = new ArrayDeque<>(Arrays.asList(cards2));
	        
	        for (int i = 0; i < goal.length; i++) {
	        	String g = goal[i];
	        	
	        	if (!queue1.isEmpty() && g.equals(queue1.element())) {
	        		queue1.poll();
	        	} else if (!queue2.isEmpty() && g.equals(queue2.element())) {
	        		queue2.poll();
	        	} else return "No";
	        }
	        return "Yes";
    }
}