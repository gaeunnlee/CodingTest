
import java.util.HashMap;
import java.util.Scanner;


class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] code = sc.nextLine().toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		int time = 0;
		int k = -1;
		
		for ( int i = 0; i < 26; i++ ) {
			char c = (char)(65 + i);
			if ( c!= 'S' && c != 'Z') k++;
			map.put( c,  k / 3 + 3 );
		}
		
		for (char c : code) time += map.get(c);
		
		System.out.println(time);
		
	}

}
