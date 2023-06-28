import java.util.*;

public class 베스트앨범 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(solution(genres, plays)));
    }

    private static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreCountMap = new HashMap<>();
        List<Song> songs = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            genreCountMap.put(genres[i], genreCountMap.getOrDefault(genres[i], 0) + plays[i]);
            songs.add(new Song(i, genres[i], plays[i]));
        }

        songs.sort(Comparator.comparing((Song s) -> genreCountMap.get(s.getGenre()))
                .thenComparing(Song::getGenre)
                .thenComparingInt(Song::getPlayCount)
                .reversed());

        List<Integer> result = new ArrayList<>();
        int tempCount = 0;
        String curGenre = songs.get(0).getGenre();
        for (Song song : songs) {
            if (isSongEqualCurGenre(curGenre, song)) {
                curGenre = song.getGenre();
                tempCount = 0;
            }
            if (tempCount == 2) {
                continue;
            }
            result.add(song.getId());
            tempCount++;
        }

        return result.stream().mapToInt(Integer::intValue)
                .toArray();
    }

    private static boolean isSongEqualCurGenre(String curGenre, Song song) {
        return !song.getGenre().equals(curGenre);
    }

    private static class Song {
        
        private final int id;

        private final String genre;

        private final int playCount;

        public Song(int id, String genre, int playCount) {
            this.id = id;
            this.genre = genre;
            this.playCount = playCount;
        }

        public int getId() {
            return id;
        }

        public String getGenre() {
            return genre;
        }

        public int getPlayCount() {
            return playCount;
        }
    }
}
