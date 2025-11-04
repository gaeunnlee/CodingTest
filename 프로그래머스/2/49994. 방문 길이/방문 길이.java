import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
     	  int x = 0, y = 0; 
          Set<String> edges = new HashSet<>();
          int answer = 0;

          for (char c : dirs.toCharArray()) {
              int nx = x, ny = y;
              switch (c) {
                  case 'U': ny += 1; break;
                  case 'D': ny -= 1; break;
                  case 'L': nx -= 1; break;
                  case 'R': nx += 1; break;
              }
              
              if (nx < -5 || nx > 5 || ny < -5 || ny > 5) {
                  continue; 
              }

              
              String a = x + "," + y;
              String b = nx + "," + ny;
              String key = a.compareTo(b) < 0 ? a + "->" + b : b + "->" + a;

              if (edges.add(key)) { 
                  answer++;
              }

              x = nx; y = ny;
          }
          return answer;
    }
}