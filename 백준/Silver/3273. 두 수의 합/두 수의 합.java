import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        // 서로 다른 양의 정수들이므로 key를 value로 설정해도 괜찮음
        Map<Integer, Integer> map = new HashMap<>(); // value, index

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            numbers[i] = num;
            map.put(num, i);
        }

        int x = Integer.parseInt(br.readLine());

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int num = numbers[i];
            int target = x - num;
            if (map.get(target) != null && map.get(target) > i) {
                answer++;
            }
        }

        System.out.println(answer);

    }
}