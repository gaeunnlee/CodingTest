import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int min = 1;
        int max = distance;
        
        while (min <= max) {
            int mid = min + (max - min) / 2;
            int prev = 0;
            int removeCnt = 0;
            
            for (int rock: rocks) {
                if (rock - prev < mid) {
                    removeCnt++;
                } else {
                    prev = rock;
                }
            }
            
            if (distance - prev < mid) {
                removeCnt++;
            }
            
            if (removeCnt > n) {
                max = mid - 1;
            } else {
                answer = mid;
                min = mid + 1;
            }
            
           
            
        }
         return answer;
    }
}