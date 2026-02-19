import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long INF;
    static final int MAXLEN = 30; 

    static int nextState(int s, int d) {
        if (s == 3) return 3;
        if (d == 6) {
            if (s == 0) return 1;
            if (s == 1) return 2;
            return 3; 
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        INF = (long) N + 1;

        long[][] ways = new long[MAXLEN + 1][4];
        ways[0][3] = 1;

        for (int len = 1; len <= MAXLEN; len++) {
            for (int s = 0; s < 4; s++) {
                long total = 0;
                for (int d = 0; d <= 9; d++) {
                    int ns = nextState(s, d);
                    total += ways[len - 1][ns];
                    if (total >= INF) { // 캡
                        total = INF;
                        break;
                    }
                }
                ways[len][s] = total;
            }
        }

        
        long[] countLen = new long[MAXLEN + 1];
        for (int L = 1; L <= MAXLEN; L++) {
            long total = 0;
            for (int first = 1; first <= 9; first++) {
                int ns = nextState(0, first);
                total += ways[L - 1][ns];
                if (total >= INF) {
                    total = INF;
                    break;
                }
            }
            countLen[L] = total;
        }

        // N이 속한 자리수 찾기
        long cum = 0;
        int targetLen = -1;
        long nthInLen = -1;
        for (int L = 1; L <= MAXLEN; L++) {
            if (cum + countLen[L] >= N) {
                targetLen = L;
                nthInLen = (long) N - cum;
                break;
            }
            cum += countLen[L];
        }

        StringBuilder ans = new StringBuilder();
        int state = 0;

        for (int pos = 0; pos < targetLen; pos++) {
            int startDigit = (pos == 0) ? 1 : 0;
            int rem = targetLen - pos - 1;

            for (int d = startDigit; d <= 9; d++) {
                int ns = nextState(state, d);
                long cnt = ways[rem][ns];

                if (nthInLen > cnt) {
                    nthInLen -= cnt;
                } else {
                    ans.append(d);
                    state = ns;
                    break;
                }
            }
        }

        System.out.println(ans.toString());
    }
}
