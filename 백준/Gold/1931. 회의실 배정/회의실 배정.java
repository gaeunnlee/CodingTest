import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st;
		int[][] meetings = new int[n][2];
		int answer = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			meetings[i][0] = start;
			meetings[i][1] = end;
		}

		Arrays.sort(meetings, (a, b) -> {
			if (a[1] == b[1]) return a[0] - b[0];
			return a[1] - b[1];
		});

		int start = meetings[0][0];

		for (int i = 0; i < n; i++) {
			if (meetings[i][0] >= start) {
				answer++;
				start = meetings[i][1];
			}
		}

		System.out.println(answer);
	}

}