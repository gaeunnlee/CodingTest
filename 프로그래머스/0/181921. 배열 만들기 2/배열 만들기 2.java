import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


class Solution {
    public static int[] solution(int l, int r) {
        int k = l;
        
        List<Integer> arr = new ArrayList<Integer> ();
       
    	while (!isContain(k) && k < r ) {
    		k++;	
    	}

    	if (!isContain(k)) return IntStream.of(-1).toArray();
    
    	for (int i = k; i <= r; i++) {
    		if (isContain(i)) {
    			arr.add(i);
    		}
    	}
    	
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
    
    static boolean isContain(int n) {    	
    	String str = Integer.toString(n);
    	for (int i = 0; i < str.length(); i++ ) {
    		char c = str.charAt(i);
    		if (c != '5' && c != '0') {
    			return false;
    		}  
    	}
 	   return true;
    }
    
}