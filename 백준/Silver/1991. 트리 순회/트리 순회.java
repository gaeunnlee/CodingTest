import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		Map<Character, Node> nodeMap = new HashMap<>();

		for (int i = 0; i < N; i++) {
			char[] line = sc.nextLine().toCharArray();
			char key = line[0];
			Node node = new Node(key);
			node.leftValue = line[2] == '.' ? null : line[2];
			node.rightValue = line[4] == '.' ? null : line[4];
			nodeMap.put(key, node);
		}

		StringBuilder preorder_sb = new StringBuilder();
		preorder('A', preorder_sb, nodeMap);

		StringBuilder inorder_sb = new StringBuilder();
		inorder('A', inorder_sb, nodeMap);

		StringBuilder postorder_sb = new StringBuilder();
		postorder('A', postorder_sb, nodeMap);

		System.out
				.println(preorder_sb.toString() + "\n" + inorder_sb.toString() + "\n" + postorder_sb.toString() + "\n");

	}

	static void preorder(Character c, StringBuilder sb, Map<Character, Node> nodeMap) {
		if (c != null) {
			sb.append(c);
			Node n = nodeMap.get(c);
			preorder(n.leftValue, sb, nodeMap);
			preorder(n.rightValue, sb, nodeMap);
		}

	}

	static void inorder(Character c, StringBuilder sb, Map<Character, Node> nodeMap) {
		if (c != null) {
			Node n = nodeMap.get(c);
			inorder(n.leftValue, sb, nodeMap);
			sb.append(c);
			inorder(n.rightValue, sb, nodeMap);
		}

	}

	static void postorder(Character c, StringBuilder sb, Map<Character, Node> nodeMap) {
		if (c != null) {
			Node n = nodeMap.get(c);
			postorder(n.leftValue, sb, nodeMap);
			postorder(n.rightValue, sb, nodeMap);
			sb.append(c);
		}

	}

	static class Node {
		Character value;
		Character leftValue;
		Character rightValue;

		Node(Character value) {
			this.value = value;
		}
	}
}
