import java.util.Scanner;

public class Main {
	static int[] nodes;
	static int[] ranks;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); int m = sc.nextInt();

		nodes = new int[n+1]; ranks = new int[n+1];

		for (int i = 0; i <= n; i++) {
			nodes[i] = i;
			ranks[i] = 0;
		}

		for (int i = 0; i < m; i++) {
			int operation = sc.nextInt();
			int a = sc.nextInt(); int b = sc.nextInt();

			switch (operation) {
			case 0:
				union(a, b);
				break;
			case 1:
				hasSameRoot(a, b);
				break;
			}
		}

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

	static void hasSameRoot(int a, int b) {
		System.out.println(findRoot(nodes[a]) == findRoot(nodes[b]) ? "YES" : "NO");
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
