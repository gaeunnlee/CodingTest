import java.util.LinkedHashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		Map<String, Member> memberMap = new LinkedHashMap<>();
		Member center = new Member("center");

		for (String e : enroll)
			memberMap.put(e, new Member(e));

		int k = 0;
		for (Member m : memberMap.values()) {
			String refName = referral[k];
			m.refMember = refName.equals("-") ? center : memberMap.get(refName);
			k++;
		}

		for (int i = 0; i < seller.length; i++) {
			Member sellerMember = memberMap.get(seller[i]);
			int revenue = amount[i] * 100;
			distributeRevenue(sellerMember, revenue);
		}

		return memberMap.values().stream().mapToInt(m -> m.revenue).toArray();
	}

	static void distributeRevenue(Member m, int revenue) {
		if (m == null)
			return;
		int refRevenue = (int) Math.floor(revenue * 0.1);
		m.revenue += revenue - refRevenue;
		if (refRevenue < 1)
			return;
		distributeRevenue(m.refMember, refRevenue);

	}

	static class Member {
		String name;
		int revenue;
		Member refMember;

		Member(String name) {
			this.name = name;
		}
	}
}