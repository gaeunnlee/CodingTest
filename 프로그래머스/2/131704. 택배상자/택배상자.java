import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        Stack < Integer > stack = new Stack < > ();
        Stack < Integer > temp = new Stack < > ();
        int cnt = 0;

        for (int i = order.length; i > 0; i--) {
            stack.push(i);
        }


       while (cnt < order.length) {
           if (stack.isEmpty()) break;
           
           if (stack.peek() == order[cnt]) {
                stack.pop();
                cnt++;
                continue;
            } 
           
            if (!temp.isEmpty() && temp.peek() == order[cnt]) {
                temp.pop();
                cnt++;
                continue;
             } 
           
            temp.push(stack.pop());  
       }
        
        while (!temp.isEmpty()) {
            if (temp.peek() == order[cnt]) {
                temp.pop();
                cnt++;
                continue;
            }
            
            return cnt;
        }
        
        


        return cnt;
    }
}