import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int available = n - lost.length;
        
        boolean[] reserveArr = new boolean[n + 1];
        int[] finalBorrow = new int[n+1];
        
        for (int i = 0; i < reserve.length; i++) reserveArr[reserve[i]] = true;
        
        for (int lostStudent: lost) {
            if (reserveArr[lostStudent]) {
                reserveArr[lostStudent] = false;
                finalBorrow[lostStudent] = lostStudent;
                available++;
            }
        }
        
        for (int lostStudent: lost) {
            
            if (finalBorrow[lostStudent] > 0) continue;
            
            boolean front = lostStudent > 1 && reserveArr[lostStudent - 1];
            boolean rear = lostStudent < n && reserveArr[lostStudent + 1];
            
            if (front && rear) {
                finalBorrow[lostStudent] = -1;
                continue;
            } else if (front) {
                finalBorrow[lostStudent] = lostStudent - 1;
                reserveArr[lostStudent - 1] = false;
                available++;
            } else if (rear) {
                finalBorrow[lostStudent] = lostStudent + 1;
                reserveArr[lostStudent + 1] = false;
                available++;
            }
        }
        
        for (int lostStudent: lost) {
            if (finalBorrow[lostStudent] == -1) {
                boolean front = lostStudent > 1 && reserveArr[lostStudent - 1];
                boolean rear = lostStudent < n && reserveArr[lostStudent + 1];
                if (front) {
                    reserveArr[lostStudent-1] = false; 
                    available++;
                } else if (rear) {
                    reserveArr[lostStudent+1] = false;
                    available++;
                }
            } 
        }
        return available;
    }
}