import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] sudoku = new int[9][9];
	static int answer = 0;
	static int[] arr;
	static int n;
	static int s;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		for (int i = 0; i < n ; i++) {
			comb(i, new ArrayList<>(List.of(arr[i])));
		}
		
		System.out.println(answer);
	}

	static void comb(int index, List<Integer> temp) {
		int sum = temp.stream().mapToInt(i -> i).sum();

		if (sum == s) answer++;

		for (int i = index + 1; i < n; i++) {
			List<Integer> list = new ArrayList<>(temp);
			list.add(arr[i]);
			comb(i, list);
		}
	}
}