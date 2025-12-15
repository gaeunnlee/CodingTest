import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		boolean[] arr = new boolean[N + 1];

		int remove = 0;
		int cnt = 0;

		int primeNum = 2;
		int i = 1;

		while (cnt < K) {
			int nextNum = primeNum * i;

			if (nextNum > N) {
				for (int j = primeNum + 1; j <= N; j++) {
					if (!arr[j]) {
						primeNum = j;
						i = 1;
						break;
					}
				}
				continue;
			}

			if (!arr[nextNum]) {
				remove = nextNum;
				arr[nextNum] = true;
				cnt++;
			}

			i++;
		}

		System.out.println(remove);
	}

}
