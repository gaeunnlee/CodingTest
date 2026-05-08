import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> genre = new HashMap<>();
        HashMap<String, ArrayList<int[]>> music = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int cnt = plays[i];
            
            genre.put(g, genre.getOrDefault(g, 0) + cnt);
            music.computeIfAbsent(g, key -> new ArrayList<>()).add(new int[] {i, cnt});
        }
        
        List<String> list = new ArrayList<>(genre.keySet());
        list.sort((a, b) -> genre.get(b) - genre.get(a));
        
        List<Integer> answer = new ArrayList<>();
        
        for (String g: list) {
            
            List<int[]> musics = music.get(g);
            musics.sort((a, b) -> {
                if (a[1] == b[1]) {
                    return Integer.compare(a[0], b[0]);
                }
                
                return Integer.compare(b[1], a[1]);
            });
            
            answer.add(musics.get(0)[0]);
            
            if (musics.size() > 1) {
                answer.add(musics.get(1)[0]);
            }
            
        }
        
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}