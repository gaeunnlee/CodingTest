import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    
    static int maxSheep;

	public int solution(int[] info, int[][] edges) {
		Map<Integer, Node> nodeMap = new HashMap<>();
		List<Node> availableNodes = new ArrayList<>();
		
		for (int i = 0; i < info.length; i++)
			nodeMap.put(i, new Node(i, info[i]));
		for (int[] edge : edges)
			nodeMap.get(edge[0]).childList.add(nodeMap.get(edge[1]));
		
		availableNodes.add(nodeMap.get(0));
		
		dfs(0,0, availableNodes);
		
		return maxSheep;
	}

	static void dfs(int sheep, int wolf, List<Node> availableNodes) {
		maxSheep = Math.max(sheep, maxSheep);
		
		for (Node next: availableNodes) {
			int nextSheep = sheep;
			int nextWolf = wolf;
			
			if (next.value == 0) nextSheep++;
			else nextWolf++;
			
			if (nextWolf >= nextSheep) continue;
			
			List<Node> nextAvailableNodes = new ArrayList<>(availableNodes);
			nextAvailableNodes.remove(next);
			nextAvailableNodes.addAll(next.childList);
			
			dfs(nextSheep, nextWolf, nextAvailableNodes);
		}

	}

	static class Node {
		int id;
		int value;
		List<Node> childList;

		Node(int id, int value) {
			this.id = id;
			this.value = value;
			this.childList = new ArrayList<>();
		}
	}

}