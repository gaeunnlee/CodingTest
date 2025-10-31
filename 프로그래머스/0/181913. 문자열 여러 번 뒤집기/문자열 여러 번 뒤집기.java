class Solution {
    public String solution(String my_string, int[][] queries) {
        StringBuilder sb = new StringBuilder();
        StringBuilder substr = new StringBuilder();
        
        sb.append(my_string);
        for (int[] query: queries) {
        	substr.setLength(0);
        	substr.append(sb.substring(query[0], query[1] + 1)).reverse();
        	sb.replace(query[0], query[1] + 1, substr.toString());
        }
        
        return sb.toString();
    }
}