import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String str = sc.nextLine();
		System.out.println(solution(n, str));
	}
	
	public static int solution(int n, String str) {
		int sum = 0;		
		for ( int i = 0; i < n; i++) {		
			sum += Character.getNumericValue(str.charAt(i));
		}
		
		return sum;		
	}

}
