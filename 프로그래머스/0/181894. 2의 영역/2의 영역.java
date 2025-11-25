import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int start = -1;
        int end = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2 ) {
                if (start >= 0) {
                    end = i;
                } else {
                    start = i;
                    end = i;
                }
            } 
        }
        
        if (start == -1) return new int[] {-1};
        
        return Arrays.copyOfRange(arr, start, end + 1);
    }
}