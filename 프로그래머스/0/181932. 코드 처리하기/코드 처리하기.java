class Solution {
    public String solution(String code) {
        String answer = "";
        String[] words = code.split("");

        int mode = 0;

        for (int i = 0; i < code.length(); i++) {
            boolean isModeZero = mode == 0;

            if (words[i].equals("1")) {
                mode = isModeZero ? 1 : 0;
            } else if (i % 2 == (isModeZero ? 0 : 1)) {
                answer += words[i];
            }

        }

        return answer.length() == 0 ? "EMPTY" : answer;
    }
}