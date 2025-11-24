import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int canChocie = nums.length / 2;
        int choiceCnt = 0;
        Set<Integer> choiceSet = new HashSet<>();
        Map<Integer, Integer> poncketmon = new HashMap<>();
        
        for (int n : nums) {
            poncketmon.put(n, poncketmon.getOrDefault(n, 0) + 1);
        }
        
        int keySize = poncketmon.keySet().size(); 
        
        if (keySize >= canChocie) {
            return canChocie;
        } else {
            while (choiceCnt < canChocie) {
                for (Map.Entry<Integer,Integer> entry: poncketmon.entrySet()) {
                    int key = entry.getKey();
                    int value = entry.getValue();
                    if (value == 0) continue;
                    poncketmon.put(key, entry.getValue() - 1);
                    choiceSet.add(key);
                    choiceCnt++;
                }
                
            }
        }
        
        return choiceSet.size();
    }
}