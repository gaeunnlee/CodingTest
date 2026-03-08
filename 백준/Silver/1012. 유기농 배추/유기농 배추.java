import java.util.*;
import java.io.*;

class Main {

    static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int xLength = Integer.parseInt(st.nextToken());
            int yLength = Integer.parseInt(st.nextToken());
            int cabbageCnt = Integer.parseInt(st.nextToken());
            int bugCnt = 0;

            int[][] map = new int[yLength][xLength];
            boolean[][] visited = new boolean[yLength][xLength];


            for (int j = 0; j < cabbageCnt; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }

            for ( int y = 0; y < yLength; y++ ) {
                for ( int x = 0; x < xLength; x++ ){
                    if (!visited[y][x] && map[y][x] == 1) {
                        visited[y][x] = true;
                        bfs(y, x, map, visited);
                        bugCnt++;
                    }
                }
            }
            sb.append(bugCnt).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void bfs(int y, int x, int[][] map, boolean[][] visited) {

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y, x});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];

            for (int i = 0; i < 4; i++) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (ny < 0 || ny >= map.length || nx < 0 || nx >= map[0].length) continue;
                if (map[ny][nx] == 0 || visited[ny][nx]) continue;

                visited[ny][nx] = true;
                queue.add(new int[]{ny, nx});
            }
        }

    }
}