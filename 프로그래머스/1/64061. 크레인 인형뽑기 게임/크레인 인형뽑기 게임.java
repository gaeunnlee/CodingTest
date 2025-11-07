import java.util.Stack;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();
        int N = board[0].length;
        int[] peeks = IntStream.range(0, N).map(i -> -1).toArray();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                peeks[j] = board[i][j] > 0 && peeks[j] == -1 ? i :peeks[j];
            }
        }
        
        for (int move : moves) {
            int x = move - 1;
            int y = peeks[x];
            
            if (peeks[x] == -1 || peeks[x] == N || board[y][x] == 0) continue;
            
            if (!st.isEmpty() && st.peek() == board[y][x]) {
                st.pop();
                answer += 2;
            } else {
                st.push(board[y][x]);
            }
            
            board[y][x] = 0;
            peeks[x] = y < N ? ++y : peeks[x];
        }
        
        return answer;
    }
}