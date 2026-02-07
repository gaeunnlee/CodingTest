import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        int min = 1;
        int max = distance;

        Arrays.sort(rocks);

        while (min <= max) {
            int mid = (min + max) / 2;

            int removeCnt = 0;
            int prev = 0;

            for (int r : rocks) {
                if (r - prev < mid) {   
                    removeCnt++;
                } else {
                    prev = r;
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
