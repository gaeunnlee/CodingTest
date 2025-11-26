class Solution {
    static boolean[] visited;
    static int[][] network;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        network = computers;
        
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            answer++;
            dfs(i);
        }
        
        return answer;
    }
    
    void dfs(int n) {
        visited[n] = true;
        for (int i = 0; i < network[n].length; i++ ) {
            if (i == n || visited[i] || network[n][i] == 0) continue;
            dfs(i);
        }
    }
}