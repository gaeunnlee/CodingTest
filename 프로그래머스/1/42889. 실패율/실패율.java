import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int N, int[] players) {
  int[] answer = new int[N + 2];
        double[] fail = new double[N+2];
        
        HashMap<Integer, Integer> table = new HashMap<>();
        
        
        for (int stage: players) {
        	table.put(stage, table.get(stage) == null ? 1 : table.get(stage) + 1);
        }
        
        for (int i = 1; i <= N + 2; i++) {
        	
        	if (table.get(i) == null) continue;
        	
        	int temp = 0;
        	
        	for (int j = i; j <= N + 2; j++) {
        		temp += table.get(j) == null ? 0 : table.get(j);
        	}
        	
        	fail[i] =  (double)table.get(i) / (double)temp;
        	
        }
        
        
        return IntStream.rangeClosed(1,N).boxed().sorted((a,b) -> Double.compare(fail[b], fail[a])).mapToInt(i -> i).toArray();

    }
}