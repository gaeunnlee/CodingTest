import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string, int[] indices) {
        StringBuilder answer = new StringBuilder();
		Set<Integer> indiceSet = new HashSet<Integer>(Arrays.stream(indices).boxed().collect(Collectors.toSet()));
		for (int i = 0; i < my_string.length(); i++ ) {
			if (!indiceSet.contains(i))	answer.append(my_string.charAt(i));
		}
		return answer.toString();
    }
}