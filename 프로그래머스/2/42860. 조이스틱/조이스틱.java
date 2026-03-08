class Solution {
    public int solution(String name) {
        int answer = 0;
        int n = name.length();

        // 문자 변경 횟수
        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }

        // 커서 이동 횟수
        int move = n - 1;

        for (int i = 0; i < n; i++) {
            int next = i + 1;

            // A 구간 건너뛰는 이동 
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }
            
            // 앞부분 처리 후 뒷부분 처리
            move = Math.min(move, i * 2 + (n - next));
            
            // 뒷부분 처리 후 앞부분 처리
            move = Math.min(move, (n - next) * 2 + i);
        }

        return answer + move;
    }
}