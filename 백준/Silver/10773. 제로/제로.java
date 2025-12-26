import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(bf.readLine());
		Stack<Integer> stack = new Stack<>();
		int sum = 0;

		for (int i = 0; i < k; i++) {
			int n = Integer.parseInt(bf.readLine());
			if (n == 0 && !stack.isEmpty()) {
				stack.pop();
				continue;
			}
			stack.push(n);
		}

		while (!stack.isEmpty()) {
			sum += stack.pop();
		}

		System.out.println(sum);
	}
}
