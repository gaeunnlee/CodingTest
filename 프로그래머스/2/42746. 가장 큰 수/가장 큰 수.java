import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        
        String[] strArr = new String[numbers.length];
        
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = numbers[i] + "";
        }
        
        Arrays.sort(strArr, (a, b) -> (b + a).compareTo(a + b));
        
        for (String str: strArr) {
            answer.append(str);
        }
        
        if (strArr[0].equals("0")) {
            return "0";
        }
        
        return answer.toString();
    }
}