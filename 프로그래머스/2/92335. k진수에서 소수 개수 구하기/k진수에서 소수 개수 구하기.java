class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String res = Integer.toString(n, k);
        String[] tokens = res.split("0");
        
        for (String token : tokens) {
            if (token.length() == 0) continue;
            long num = Long.parseLong(token);
            if (isPrime(num)) answer++;
        }
        
        return answer;
    } 
    
    boolean isPrime(long num) {
        if (num == 1) return false;
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        
        return true;
    }
}