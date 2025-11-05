import java.util.Stack;

class Solution {
    public int solution(String s) {
	int answer = 0;
		Stack<Character> st = new Stack<>();
		StringBuilder sb = new StringBuilder(s);

		for (int i = 0; i < s.length(); i++) {
			String str = sb.substring(i, sb.length()) + sb.substring(0, i);
			char[] cArr = str.toCharArray();

			for (char c : cArr) {
				if (c == '[' || c == '{' || c == '(') {
					st.push(c);
				} else {
					if (st.isEmpty()) {
						st.push(c);
						continue;
					}
					if ((c == ']' && st.peek() == '[') || (c == ')' && st.peek() == '(')
							|| (c == '}' && st.peek() == '{')) {
						st.pop();
					} else {
						break;
					}
				}
			}

			if (st.isEmpty()) {
				answer++;
			}
			
			st.setSize(0);
		}

		return answer;
    }
}