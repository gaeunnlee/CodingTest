import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static int[][] solution(int[][] nodeinfo) {
		Node[] nodeArr = new Node[nodeinfo.length];

		for (int i = 0; i < nodeinfo.length; i++)
			nodeArr[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);

		// 이진 트리 삽입 순서 위해 정렬
		Arrays.sort(nodeArr, (o1, o2) -> {
			if (o1.y == o2.y)
				return o1.x - o1.x;
			return o2.y - o1.y;
		});

		Node root = nodeArr[0];

		// 루트 노드의 자식부터 연결
		for (int i = 1; i < nodeinfo.length; i++) {
			Node parent = root;
			insertNode(parent, nodeArr[i]);
		}

		List<Integer> preorderList = new ArrayList<>();
		List<Integer> postorderList = new ArrayList<>();
		
		int[][] answer = new int[2][1];

		answer[0] = preorder(root, preorderList).stream().mapToInt(i -> i).toArray();
		answer[1] = postorder(root, postorderList).stream().mapToInt(i -> i).toArray();

		return answer;
	}

	static void insertNode(Node parent, Node child) {
		if (parent.x > child.x) {
			if (parent.left == null) 
				parent.left = child;
			else // 자리 없으면 그 다음 자식 노드로 삽입
				insertNode(parent.left, child);
		} else {
			if (parent.right == null)
				parent.right = child;
			else
				insertNode(parent.right, child);
		}
	}

	static List<Integer> preorder(Node node, List<Integer> preorderList) {
		if (node == null) return null;
		preorderList.add(node.id);
		preorder(node.left, preorderList);
		preorder(node.right, preorderList);
		
		return preorderList;
	}

	static List<Integer> postorder(Node node, List<Integer> postorderList) {
		if (node == null) return null;
		postorder(node.left, postorderList);
		postorder(node.right, postorderList);
		postorderList.add(node.id);
		
		return postorderList;
	}

	static class Node {
		int id;
		int x;
		int y;
		Node left;
		Node right;

		Node(int id, int x, int y) {
			this.id = id;
			this.x = x;
			this.y = y;
		}
	}

}
