import java.util.*;
import java.io.*;

class Main {
    
    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        double[] p = new double[4];
        boolean[][] visited = new boolean[2 * n + 1][2 * n + 1];
        
        for (int i = 0; i < 4; i++) {
            p[i] = Integer.parseInt(st.nextToken()) / 100.0 ;
        }
        
        visited[n][n] = true;
        System.out.println(backtrack(n, n, p, visited, 1.0, 0));
        
        
        
    }
    
    
    static double backtrack(int y, int x, double[] p, boolean[][] visited, double cur, int cnt) {
        
        double result = 0;
        
        if (n == cnt) {
            return cur;
        }
        
        int[][] dir = {{0, 1}, {0, -1}, { 1, 0 }, {-1, 0}};
        
        for (int i = 0; i < 4; i++) {
            if (p[i] == 0) continue;
            
            int ny = y + dir[i][0];
            int nx = x + dir[i][1];
            
            if ( ny < 0 || ny > 2 * n || nx < 0 || nx > 2 * n) continue;
            if (visited[ny][nx]) continue;
            
            visited[ny][nx] = true;
            
            result += backtrack(ny, nx, p, visited, cur * p[i], cnt + 1);
            
            visited[ny][nx] = false;
            
        }
        
        return result;
        
    }
}