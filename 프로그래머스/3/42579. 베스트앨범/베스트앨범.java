import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answerList = new ArrayList<>();
        
        HashMap<String, Integer> genreTotalPlayCnt = new HashMap<>();
        HashMap<String, ArrayList<int[]>> musicsByGenre = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int cnt = plays[i];
            
            genreTotalPlayCnt.put(g, genreTotalPlayCnt.getOrDefault(g, 0) + cnt);
            
            if (musicsByGenre.get(g) == null) {
                musicsByGenre.put(g, new ArrayList<int[]>());
            }
            
            musicsByGenre.get(g).add(new int[]{i, cnt});
            
        }
        
        ArrayList<String> sortedGenre = new ArrayList<String>(genreTotalPlayCnt.keySet());
        Collections.sort(sortedGenre, (a, b) -> genreTotalPlayCnt.get(b) - genreTotalPlayCnt.get(a));
        
        
        for (String g: sortedGenre) {
            ArrayList<int[]> sortedMusic = new ArrayList<int[]>(musicsByGenre.get(g));
            Collections.sort(sortedMusic, (a, b) -> {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                } else {
                    return b[1] - a[1];
                }
            });
                
            answerList.add(sortedMusic.get(0)[0]);
            if (sortedMusic.size() > 1) answerList.add(sortedMusic.get(1)[0]);
        }
        
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}