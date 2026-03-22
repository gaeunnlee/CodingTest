import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static int[] dy = {-1, 0, 0, 1};
    static int[] dx = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int sharkY = 0, sharkX = 0;
        int sharkSize = 2;
        int eatCnt = 0;
        int totalTime = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkY = i;
                    sharkX = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            int[] target = bfs(sharkY, sharkX, sharkSize);

            if (target == null) break;

            sharkY = target[0];
            sharkX = target[1];
            totalTime += target[2];

            map[sharkY][sharkX] = 0;
            eatCnt++;

            if (eatCnt == sharkSize) {
                sharkSize++;
                eatCnt = 0;
            }
        }

        System.out.println(totalTime);
    }

    static int[] bfs(int sharkY, int sharkX, int sharkSize) {
        boolean[][] visited = new boolean[N][N];
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{sharkY, sharkX, 0});
        visited[sharkY][sharkX] = true;

        int minDist = Integer.MAX_VALUE;
        int targetY = Integer.MAX_VALUE;
        int targetX = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            int dist = cur[2];

            if (dist > minDist) continue;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if (visited[ny][nx]) continue;
                if (map[ny][nx] > sharkSize) continue;

                visited[ny][nx] = true;

                if (map[ny][nx] != 0 && map[ny][nx] < sharkSize) {
                    if (dist + 1 < minDist) {
                        minDist = dist + 1;
                        targetY = ny;
                        targetX = nx;
                    } else if (dist + 1 == minDist) {
                        if (ny < targetY || (ny == targetY && nx < targetX)) {
                            targetY = ny;
                            targetX = nx;
                        }
                    }
                }

                queue.offer(new int[]{ny, nx, dist + 1});
            }
        }

        if (minDist == Integer.MAX_VALUE) return null;
        return new int[]{targetY, targetX, minDist};
    }
}