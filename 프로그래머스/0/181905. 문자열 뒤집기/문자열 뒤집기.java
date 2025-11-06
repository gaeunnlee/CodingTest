class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder();
        StringBuilder reverse_sb = new StringBuilder(my_string.substring(s,e + 1));
        
        
        sb.append(my_string.substring(0,s));
        sb.append(reverse_sb.reverse().toString());
        sb.append(my_string.substring(e+1));
        
        
        return sb.toString();
    }
}