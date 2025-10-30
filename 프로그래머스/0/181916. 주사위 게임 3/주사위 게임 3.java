import java.util.Arrays;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] dice = {a, b, c, d};
    int[] arr = new int[7];
    
    for (int i = 0; i < 4; i++) {
    	arr[dice[i]] += 1;
    }
    
    int sameSize;
    int p = 0; int q = 0; int r = 0;
    
   sameSize = Arrays.stream(arr).max().orElse(0);
   
   if (sameSize == 1) return Arrays.stream(dice).min().orElse(0);
   if (sameSize == 4) return a * 1111;
   
    for (int i = 1; i <= 6; i++) {
    	switch (arr[i]) {
    		case 1:
    			if (q == 0) q = i;
    			else r = i;
    			break;
    		case 2:
    			if ( p ==0 ) p = i;
    			else q = i;
    			break;
    		case 3:
    			p = i;
    			break;
    	}
    }
    
    if (sameSize == 3) {
    	return (int) Math.pow(10 * p + q,2);
    } else if (sameSize == 2) {
    	return r == 0 ?  (p + q) * Math.abs(p - q) : q * r;
    }
   
    return 0;
    }
}