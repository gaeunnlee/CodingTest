import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int[] answer = {};
        int a = slicer[0]; int b = slicer[1]; int c = slicer[2];
        
        switch (n) {
            case 1: 
                return Arrays.copyOfRange(num_list, 0, b + 1);
            case 2:
                return Arrays.copyOfRange(num_list, a, num_list.length);
            case 3:
                return Arrays.copyOfRange(num_list, a, b + 1);
            case 4:
                int[] arr = Arrays.copyOfRange(num_list, a, b + 1);
                return IntStream.rangeClosed(0, b - a).filter(i -> i % c == 0).map(i -> arr[i]).toArray();
        }
        return answer;
    }
}