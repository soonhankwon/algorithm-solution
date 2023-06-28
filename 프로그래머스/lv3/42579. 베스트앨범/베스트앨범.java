import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
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
        String tempGenre = songs.get(0).getGenre();
        for(Song song : songs) {
            if(!song.getGenre().equals(tempGenre)) {
                tempGenre = song.getGenre();
                tempCount = 0;
            }
            if(tempCount == 2) {
                continue;
            }
            result.add(song.getId());
            tempCount++;
        }

        return result.stream().mapToInt(Integer::intValue)
                .toArray();
    }
    
    private static class Song{
        private int id;

        private String genre;

        private int playCount;

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