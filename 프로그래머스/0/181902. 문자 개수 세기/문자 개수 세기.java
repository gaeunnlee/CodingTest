import java.util.Arrays;

class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        
        for (int i = 0; i < my_string.length(); i++ ){
            char c = my_string.charAt(i);
            int index = (int) c;
             answer[index >= 97 ? index - 71 : index - 65 ] += 1;
        }
        
        
        return answer;
    }
}