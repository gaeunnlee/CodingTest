import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < t; i++) {
            String inputStr = sc.nextLine();
            int index = inputStr.indexOf(' ');
            int r = Integer.parseInt(inputStr.substring(0, index));
            String str = inputStr.substring(index + 1);
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                sb.append(String.valueOf(str.charAt(j)).repeat(r));
            }
            System.out.println(sb.toString());
        }

    }


}