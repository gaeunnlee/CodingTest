import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
		 	HashMap<String, Integer> p = new HashMap<>();
		 	StringBuilder sb = new StringBuilder();
		 	
		 	for (String name: participant) {
		 		p.put(name, p.getOrDefault(name, 0) + 1);
		 	}
		 	
		 	for (String name: completion) {
		 		int size = p.get(name);
		 		if (size == 1) p.remove(name);
		 		else p.put(name, p.get(name) - 1);
		 	}


		 	for (String key : p.keySet()) {
	            sb.append(key);
		 	}

		 	
	        return sb.toString();
    }
}