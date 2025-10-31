import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
    	 List<Integer> answer = new ArrayList<>();
    	 int r;
    	 
    	 for (int i = 0; i < intStrs.length; i++) {
    		 String intStr = intStrs[i];
    		 r = Integer.parseInt(intStr.substring(s, s + l));
    		 if (r > k) answer.add(r);	 
    	 }
    	 
         return answer.stream().mapToInt(i -> i).toArray();
    }
}