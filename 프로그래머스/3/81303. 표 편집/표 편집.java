import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String solution(int n, int k, String[] cmd) {
 

Stack<Integer> trash = new Stack<>();
		int[] up = new int[n + 2];
        int[] down = new int[n + 2];
        
        for (int i = 0; i < n+2; i++) {
        	up[i] = i - 1;
        	down[i] = i + 1;
        }
       
        k++;
        
        for (String c: cmd) {
        	char command = c.toCharArray()[0];
        	
        	switch(command) {
        		case 'U': case 'D':
        			int distance = Integer.parseInt(c.substring(c.lastIndexOf(" ") + 1));
        			for (int i = 0; i < distance; i++) {
        				k = command == 'U' ? up[k] : down[k];
        			}
        			break;
        		case 'C':
        			trash.push(k);
        			up[down[k]] = up[k];
        			down[up[k]] = down[k];
        			k = n < down[k] ? up[k] : down[k];
        			break;
        		case 'Z':
        			int z = trash.pop();
        			up[down[z]] = z;
        			down[up[z]] = z;
        			break;	
        	
        	}
        }
        
        char answer[] = new char[n];
        Arrays.fill(answer, 'O');
      
        while (!trash.isEmpty()) {
        	answer[trash.pop() - 1] = 'X';
        }
        return new String(answer);
    }
}