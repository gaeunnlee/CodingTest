import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public String[] solution(String my_string) {
	        int n  = my_string.length();
	        Set<String> s = new HashSet<>();
	        
	        for (int i = 0; i < my_string.length(); i++) {
	        	s.add(my_string.substring(i));
	        }
	        
	        
	        List<String> answer = new ArrayList<String>(s);
	        Collections.sort(answer);
	        
	        
	        return answer.toArray(new String[answer.size()]);
    }
}