import java.util.*;

class Solution {
    static int[] answer = {-1};
    static int maxDiff = Integer.MIN_VALUE;
    
    public int[] solution(int n, int[] info) {
        answer = new int[]{-1};
        maxDiff = Integer.MIN_VALUE;
        
        int[] lion = new int[11];
        
        // index = 0 -> 10점부터 백트래킹
        backtracking(0, lion, 0, n, info);
        
        return answer;
    }
    
    static void backtracking(int index, int[] lion, int lionCnt, int totalCnt, int[] apeach) {
        int currentScore = 10 - index;
        
        // 마지막 점수(0점): 남은 화살 전부 0점에 넣음
        if (currentScore == 0) {
            int remainCnt = totalCnt - lionCnt;
            lion[10] = remainCnt;
            
            int result = calculateDiff(lion, apeach);
            
            if (result > 0) {
                if (result > maxDiff) {
                    maxDiff = result;
                    answer = Arrays.copyOf(lion, 11);
                } else if (result == maxDiff && compareAndUpdateNewResult(lion)) {
                    answer = Arrays.copyOf(lion, 11);
                }
            }
            
            lion[10] = 0;
            return;
        }
        
        // (A) 어피치보다 1개 더 쏘거나, (B) 아예 안 쏘기
        int lionTargetCnt = apeach[index] + 1;
        int remainCnt = totalCnt - lionCnt;
        
        // (A)
        if (lionTargetCnt <= remainCnt) {
            lion[index] = lionTargetCnt;
            backtracking(index + 1, lion, lionCnt + lionTargetCnt, totalCnt, apeach);
            lion[index] = 0;
        }
        
        // (B)
        lion[index] = 0;
        backtracking(index + 1, lion, lionCnt, totalCnt, apeach);
        
    }
    
    static int calculateDiff(int[] lion, int[] apeach) {
        int lionScore = 0;
        int apeachScore = 0;
        
        for (int i = 0; i <= 10; i++) {
            int lionCnt = lion[i];
            int apeachCnt = apeach[i];
            int score = 10 - i;
        
            if (lionCnt == 0 && apeachCnt == 0) continue;
            
            if (lionCnt > apeachCnt) {
                lionScore += score;
            } else {
                apeachScore += score;
            }
        }
        
        return lionScore - apeachScore;
        
    }
    
    
    // 가장 낮은 점수를 더 많이 맞힌 경우
   static boolean compareAndUpdateNewResult(int[] newResult) {
        // answer가 -1인 경우 새 결과로 업데이트
        if (answer.length == 1 && answer[0] == -1) return true;

        for (int i = 10; i >= 0; i--) {
            if (answer[i] == newResult[i]) continue;
            return answer[i] < newResult[i];
        }
        return false;
    }
}