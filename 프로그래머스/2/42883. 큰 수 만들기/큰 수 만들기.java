class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int[] cnt = new int[10];
        int length = number.length() - k;
        
        for (int i = 0; i < number.length(); i++) {
            String c = number.charAt(i) + "";
            int n = Integer.parseInt(c);
            cnt[n]++;
        }
        
        for (int i = 9; i >= 0; i--) {
            while (cnt[i] > 0) {
                if (length > 0) {
                    length--;
                    cnt[i]--;
                    answer.append(i);
                } else {
                    break;
                }
            }
        }
        
        return answer.toString();
    }
}