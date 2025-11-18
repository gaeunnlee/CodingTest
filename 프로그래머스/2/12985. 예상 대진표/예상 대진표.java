class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        for (int i = 1 ; i <= n; i *= 2) {
            double rangeA = Math.ceil((double) a / i);
            double rangeB = Math.ceil((double) b / i);
            
            if (rangeA == rangeB) break;
            
            answer++;
        }

        return answer;
    }
}