import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Solution {
	public int[] solution(String[] genres, int[] plays) {
		List<Integer> answer = new ArrayList<>();
		HashMap<String, Genre> genreMap = new HashMap<>();
		HashSet<Genre> album = new HashSet<>();

		for (int i = 0; i < genres.length; i++) {
			String genre = genres[i];
			int play = plays[i];
			Genre g;
			if (!genreMap.containsKey(genre)) {
				g = new Genre(genre);
				genreMap.put(genre, g);
				album.add(g);
			} else {
				g = genreMap.get(genre);
			}
			g.addMusic(new Music(i, play));
		}

		List<Genre> genreList = new ArrayList<>(album);
		genreList.sort(
				(a, b) -> b.list.stream().mapToInt(i -> i.play).sum() - a.list.stream().mapToInt(i -> i.play).sum());

		for (Genre g : genreList) {
			List<Music> list = g.list;
			list.sort((m1, m2) -> {
				if (m2.play == m1.play) {
					return m1.number - m2.number;
				}
				return m2.play - m1.play;
			});

			int limit = list.size() == 1 ? 1 : 2;
			for (int i = 0; i < limit; i++) {
				answer.add(list.get(i).number);
			}
		}
		System.out.println(genreList);
		return answer.stream().mapToInt(i -> i).toArray();
	}

	static class Genre {
		String name;
		List<Music> list = new ArrayList<>();
		Genre(String name) {
			this.name = name;
		}
		void addMusic(Music m) {
			list.add(m);
		}
	}

	static class Music {
		int number;
		int play;

		Music(int number, int play) {
			this.number = number;
			this.play = play;
		}
	}

}