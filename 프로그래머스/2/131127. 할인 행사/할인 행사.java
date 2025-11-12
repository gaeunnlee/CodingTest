import java.util.HashMap;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        
		HashMap<String, Integer> wants = new HashMap<>();

		int k = want.length;
		int answer = 0;

		for (int i = 0; i < k; i++)
			wants.put(want[i], number[i]);

		for (int i = 0; i < discount.length - 9; i++) {
			HashMap<String, Integer> discounts = new HashMap<>();

			for (int day = i; day < i + 10; day++) {
				String item = discount[day];
				if (wants.containsKey(item)) {
					discounts.put(item, discounts.getOrDefault(item, 0) + 1);
				}

				if (discounts.equals(wants))
					answer++;
			}
		}

		return answer;
    }
}