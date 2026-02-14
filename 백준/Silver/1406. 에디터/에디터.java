import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        String input = br.readLine();
        for (int i = 0; i < input.length(); i++) {
            left.push(input.charAt(i) + "");
        }

        int cmdCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cmdCnt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();

            if ("L".equals(cmd) && !left.isEmpty()) {
                right.push(left.pop());
            } else if ("D".equals(cmd) && !right.isEmpty()) {
                left.push(right.pop());
            } else if ("B".equals(cmd) && !left.isEmpty()) {
                left.pop();
            } else if ("P".equals(cmd)) {
                left.add(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!left.isEmpty()) {
            sb.append(left.pop());
        }

        sb.reverse();

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        System.out.println(sb);


    }
}