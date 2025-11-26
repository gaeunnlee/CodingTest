import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> list = new ArrayList<>();
        int[] front = Arrays.copyOfRange(num_list, n, num_list.length);
        int[] rear = Arrays.copyOfRange(num_list, 0, n);
        
        list.addAll(Arrays.stream(front).boxed().collect(Collectors.toList()));
        list.addAll(Arrays.stream(rear).boxed().collect(Collectors.toList()));
        
        return list.stream().mapToInt(i->i).toArray();
    }
}