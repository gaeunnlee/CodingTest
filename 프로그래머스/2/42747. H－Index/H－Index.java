import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        int low =  0;
        int high = citations[citations.length - 1];
        
        while (low <= high) {
            int mid = (low + high) / 2;
            int cnt = 0;
            
            for ( int i = 0; i < citations.length; i++ ) {
                if ( citations[i] >= mid ) {
                    cnt = citations.length - i;
                    break;
                }
            }
            
            if ( cnt >= mid ) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        
        return answer;
    }
}