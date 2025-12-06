import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static Stack<Integer>[] stacks = new Stack[4];
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		for (int i = 1; i <= 3; i++) stacks[i] = new Stack<>();
		
		for (int i = n; i >= 1; i--) stacks[1].push(i); 
		
		System.out.println(hanoi(n, 1, 2, 3));
		System.out.println(sb.toString());
	}
	
	static int hanoi(int n, int from, int via, int to) {
		int move = 0;
		
		if (n == 1) {
			sb.append(from + " " + to + "\n");
			stacks[to].push(stacks[from].pop());
			return 1;
		}
		
		move += hanoi(n-1, from, to, via);
		
		sb.append(from + " " + to + "\n");
		stacks[to].push(stacks[from].pop());
		move++;
		
		move += hanoi(n-1, via, from, to);
		
		return move;
		
	}
}