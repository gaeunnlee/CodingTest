import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        
        String[][] hints = new String[n][3];
        
        for (int i = 0; i < n; i ++) {
            st = new StringTokenizer(br.readLine());
            hints[i][0] = st.nextToken();
            hints[i][1] = st.nextToken();
            hints[i][2] = st.nextToken();
        }
        
        for (int num = 123; num <= 987; num++) {
            
            String str = String.valueOf(num);
            if (str.charAt(0) == '0' || str.charAt(1) == '0' || str.charAt(2) == '0') continue;
            
            if (str.charAt(0) == str.charAt(1) || str.charAt(1) == str.charAt(2) || str.charAt(0) == str.charAt(2)) continue;
            boolean possible = true;
            
            for (String[] hint : hints) {
                
                int strike = 0;
                int ball = 0;
                
                for (int i = 0; i < 3; i ++) {
                    char c = hint[0].charAt(i);
                    
                    if (c == str.charAt(i)) strike++;
                }
                
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        char c = str.charAt(i);
                        if (c == hint[0].charAt(j) && i != j) {
                            ball++;
                        }
                    }
                }
              
                if (strike != Integer.parseInt(hint[1]) || ball != Integer.parseInt(hint[2])) {
                    possible = false;
                    break;
                }
                
            }
            
              
            
            
            if (!possible) continue;
            
            
            answer++;
            
        }
        
        System.out.println(answer);
        
        
    }
}