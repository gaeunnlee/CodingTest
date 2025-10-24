class Solution {
    public int solution(int a, int b) {
            String strA = String.valueOf(a);
	        String strB = String.valueOf(b);
	        
	        int m = Integer.parseInt(strA+strB);
	        int n = 2 * a * b;
	      	        
	        return m < n ? n : m;
    }
}