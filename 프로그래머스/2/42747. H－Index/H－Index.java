import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i;              // i번째부터 끝까지 논문 수
            if (citations[i] >= h) {    // 그 논문이 h 이상이면 h 성립
                return h;
            }
        }
        return 0;
    }
}
