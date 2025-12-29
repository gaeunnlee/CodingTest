import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] tree;
	static int[] rootArr;
	static int n;
	static int answer;
	static int rootNode;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(bf.readLine());
		tree = new ArrayList[n];
		rootArr = new int[n];

		st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < n; i++)
			tree[i] = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int root = Integer.parseInt(st.nextToken());
			rootArr[i] = root;

			if (root == -1) {
				rootNode = i;
				continue;
			}

			tree[root].add(i);
		}

		int target = Integer.parseInt(bf.readLine());

		if (target == rootNode) {
			System.out.println(0);
			return;
		}

		tree[target] = null;

		tree[rootArr[target]].remove(Integer.valueOf(target));

		dfs(rootNode);

		System.out.println(answer);

	}

	static void dfs(int current) {
		if (tree[current].isEmpty()) {
			answer++;
			return;
		}
		for (int next : tree[current])
			dfs(next);

	}

}
