import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] strArr = new String[n];
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) strArr[i] = bf.readLine();
		
		for (String str : strArr) sb.append(isPalindrome(str.toCharArray(), 1) + "\n");
		
		System.out.println(sb.toString());
	}
	
	static String isPalindrome(char[] s, int cnt) {
		return recursion(s, 0, s.length -1, 1);
	}
	
	static String recursion(char[] s, int l, int r, int cnt) {
		if (l >= r) return 1 + " " + cnt;
		else if (s[l] != s[r]) return 0 + " " + cnt;
		else return recursion(s,  l + 1, r - 1, cnt + 1);
	}
	
}