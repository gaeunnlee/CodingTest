import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        // 모든 입력을 저장
        int[] input = new int[T];
        int max = 0;

        // 입력 받으면서 가장 큰 n 찾기
        for (int i = 0; i < T; i++) {
            input[i] = Integer.parseInt(br.readLine());
            if (input[i] > max) {
                max = input[i];
            }
        }

        // dp 배열 생성
        int[] dp = new int[max + 1];

        dp[0] = 1; // 아무 것도 안 더하는 방법 1개
        dp[1] = 1; // 1
        dp[2] = 2; // 1+1, 2

        // 3부터는 이전 값으로 계산
        for (int i = 3; i <= max; i++) {

            // 마지막에 1을 붙인 경우
            dp[i] += dp[i - 1];

            // 마지막에 2를 붙인 경우
            dp[i] += dp[i - 2];

            // 마지막에 3을 붙인 경우
            dp[i] += dp[i - 3];
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int n : input) {
            sb.append(dp[n]).append('\n');
        }

        System.out.print(sb);
    }
}
