import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            comb(n, 6, 0, arr, new ArrayList<>());
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void comb(int n, int r, int i, int[] arr, List<Integer> list) {

        if (list.size() == r) {
            for (int t = 0; t < r; t++) {
                if (t > 0) sb.append(' ');
                sb.append(list.get(t));
            }
            sb.append('\n');
            return;
        }


        int rest = r - list.size();
        for (int idx = i; idx <= n - rest; idx++) {
            list.add(arr[idx]);
            comb(n, r, idx + 1, arr, list);
            list.remove(list.size() - 1);
        }

    }


}