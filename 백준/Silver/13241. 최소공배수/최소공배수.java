import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());

		List<Long> listA = division(a);
		List<Long> listB = division(b);
		listA.retainAll(listB);
		
		Collections.sort(listA);
		long gcd = listA.get(listA.size() - 1);

		System.out.println(gcd * (a / gcd) * (b / gcd));

	}

	static List<Long> division(long num) {
		List<Long> list = new ArrayList<>();
		long k = 1;
		long temp = Integer.MAX_VALUE;

		while (true) {
			if (num % k == 0) {
				if (k >= temp)
					break;
				list.add(k);
				long m = num / k;
				if (k == m)
					break;
				list.add(m);
				temp = m;
			}
			k++;
		}

		return list;

	}

}
