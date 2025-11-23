import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] nodes;
	static int[] ranks;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		nodes = new int[n + 1];
		ranks = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			nodes[i] = i;
			ranks[i] = 0;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int operation = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			switch (operation) {
			case 0:
				union(a, b);
				break;
			case 1:
				sb.append(findRoot(a) == findRoot(b) ? "YES\n" : "NO\n");
				break;
			}
		}
		
		System.out.println(sb.toString());

	}

	static void union(int a, int b) {
		int rootA = findRoot(nodes[a]);
		int rootB = findRoot(nodes[b]);

		if (ranks[rootA] == ranks[rootB]) {
			nodes[rootB] = rootA;
			ranks[rootA]++;
		} else {
			int newRoot = ranks[rootA] > ranks[rootB] ? rootA : rootB;
			int targetNode = ranks[rootA] > ranks[rootB] ? rootB : rootA;
			nodes[targetNode] = newRoot;
		}
	}

	static int findRoot(int node) {
		int root;

		if (nodes[node] == node) {
			root = node;
		} else {
			root = findRoot(nodes[node]);
			nodes[node] = root;
		}

		return root;
	}

}
