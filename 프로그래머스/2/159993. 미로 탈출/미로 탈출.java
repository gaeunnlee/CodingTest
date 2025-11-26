import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static boolean[][] visited;
    static Map<Character, int[]> position;
    static int[] dy = {0, 1, 0, -1}; static int[] dx = {1, 0, -1, 0};
    static char[][] map;
    static int X; static int Y;
    
    public int solution(String[] maps) {
        int answer = 0;
        X = maps[0].length(); Y = maps.length;
        map = new char[Y][X];
        visited = new boolean[Y][X];
        
        Queue<int[]> queue = new LinkedList<>();
        
        position = new HashMap<>();
        
        for (int i = 0; i < Y; i++) {
            String str = maps[i];
            for (int j = 0; j < X; j++) {
                char c = str.charAt(j);
                map[i][j] = c;
                
                if ( c == 'S' || c == 'E' || c == 'L') {
                    position.put(c, new int[]{i, j});
                }
            }
        }
        
       
        int leverTime = bfs('L', queue);
        if (leverTime == -1) return -1;
        else answer += leverTime;
        
        visited = new boolean[Y][X];
        queue.clear();
        
        int exitTime = bfs('E', queue);
        if (exitTime == -1) return -1;
        else answer += exitTime;
        
        return answer;
    }
    
    int bfs(char target, Queue<int[]> queue) {
        // 큐에 시작 값 넣기
        // queue.add(y, x, time);
        int startY = position.get('S')[0]; int startX = position.get('S')[1];
        queue.add(new int[]{startY, startX, 0});
        visited[startY][startX] = true;
       
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0]; int x = current[1]; int time = current[2];
            
            // 목표 위치 찾으면 시작 지점 갱신 후 종료
            if (y == position.get(target)[0] && x == position.get(target)[1]) {
                position.put('S', new int[]{y, x});
                return time;
            }
            
            for ( int i = 0; i < 4; i++ ){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= X || ny < 0 || ny >= Y) continue;
                if (map[ny][nx] == 'X' || visited[ny][nx]) continue;
                
                visited[ny][nx] = true;
                
                queue.add(new int[]{ny, nx, time + 1});
            }
        }
        
        return -1;
    }
    
}