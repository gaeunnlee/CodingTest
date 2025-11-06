class Solution {
    public int solution(String my_string, String is_suffix) {
        int index = my_string.length() - is_suffix.length();       
        if (index < 0 ) return 0;            
        return my_string.substring(index).equals(is_suffix) ? 1 : 0;
    }
}