import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
     Map<String, Set<String>> map = new LinkedHashMap<>();
        Map<String, Integer> mailResult = new LinkedHashMap<>();
        
        for (String id : id_list) {
        	map.put(id, new HashSet<>());
        	mailResult.put(id, 0);
        }
        
        for (String desc: report) {
        	String[] tokens = desc.split(" ");
        	String reporter = tokens[0];
        	String target= tokens[1];
        	
        	Set<String> reporters = map.get(target);
        	reporters.add(reporter);
        }
        
        
        for (String target : map.keySet()) {
        	Set<String> reporterSet = map.get(target);
        	if (reporterSet.size() >= k) {
        		List<String> reporterList = new ArrayList<String>(reporterSet);
            	for (String reporter :reporterList) {
            		mailResult.put(reporter, mailResult.get(reporter) + 1);
            	}
        	}
        }
        
        return mailResult.values().stream().mapToInt(i -> i).toArray();
    }
}