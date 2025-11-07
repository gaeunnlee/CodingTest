class Solution {
    public String solution(String my_string, int m, int c) {
	        StringBuilder answer = new StringBuilder();
	        int length = my_string.length();
	        
	        int y = length % m == 0 ? length / m : length / m  + 1;
	        char[] cArr = my_string.toCharArray();
	        
	        
	        for (int i = 0; i < y; i++) {
	        	int index = i * m + (c - 1);
	        	answer.append(cArr[index]);
	        }
	        
	        return answer.toString();
    }
}