import java.util.*;

class Solution {
    static class Node {
        int to, w;
        Node(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    public int solution(int n, int[][] costs) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int[] c : costs) {
            int a = c[0], b = c[1], w = c[2];
            graph.get(a).add(new Node(b, w));
            graph.get(b).add(new Node(a, w));
        }

        boolean[] visited = new boolean[n];
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.w));

        visited[0] = true;
        for (Node next : graph.get(0)) pq.offer(next);

        int total = 0;
        int connected = 1;

        while (!pq.isEmpty() && connected < n) {
            Node cur = pq.poll();

            if (visited[cur.to]) continue;

            visited[cur.to] = true;
            total += cur.w;
            connected++;

            for (Node next : graph.get(cur.to)) {
                if (!visited[next.to]) pq.offer(next);
            }
        }

        return total;
    }
}