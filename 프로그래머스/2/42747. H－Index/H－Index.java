import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        // 인용될 수 있는 논문 수이자 h
        int low =  0;
        int high = citations.length;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            int cnt = 0; // mid 미만(< mid) 인용된 논문 수
            
            for ( int n : citations ) {
                if ( n < mid ) {
                    cnt++;
                } else {
                    break;
                };
            }
            
            if (citations.length - cnt >= mid) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        
        return answer;
    }
}