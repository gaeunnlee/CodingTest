class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        boolean answer = false;

        if (ineq.equals("<")) {
            answer = eq.equals("=") ? n <= m : n < m;
        } else {
            answer = eq.equals("=") ? n >= m : n > m;
        }

        return answer ? 1 : 0;
    }
}