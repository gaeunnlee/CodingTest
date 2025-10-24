class Solution {
    public int solution(int a, int b) {
        String r1 = a  + "" + b;
        String r2 = b + "" + a;
        
        int n1 = Integer.parseInt(r1);
        int n2 = Integer.parseInt(r2);
        
        return n1 > n2 ? n1 : n2;
    }
}