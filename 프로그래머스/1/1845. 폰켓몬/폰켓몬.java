import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int n : nums) {
            set.add(n);
        }
        
        int k = nums.length / 2;
        
        return set.size() >= k ? k : set.size();
        
        
    }
}