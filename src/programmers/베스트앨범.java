package programmers;

import java.util.*;

public class 베스트앨범 {
    static HashMap<String, Integer> mostPlayed;
    static List<Genre> list; // 정렬용
    static HashMap<String, PriorityQueue> hm;
    public static int[] solution(String[] genres, int[] plays) {
        mostPlayed = new HashMap<>();
        hm = new HashMap<>();
        list = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            mostPlayed.put(genres[i], mostPlayed.getOrDefault(genres[i], 0) + plays[i]);
            if (hm.containsKey(genres[i])) {
                hm.get(genres[i]).add(new Genre(genres[i], i, plays[i]));
            } else {
                hm.put(genres[i], new PriorityQueue<Genre>((o1, o2) -> {
                    if (o1.plays == o2.plays) {
                        return Integer.compare(o1.num, o2.num);
                    } else {
                        return o2.plays - o1.plays;
                    }
                }));
                hm.get(genres[i]).add(new Genre(genres[i], i, plays[i]));
            }
        }

        // 1. hashmap 순회해서 제일 많이 재생된 장르 찾기
        for (Map.Entry<String, Integer> entry : mostPlayed.entrySet()) {
            String k = entry.getKey();
            Integer v = entry.getValue();
            list.add(new Genre(k, 0, v));
        }
        // 2. 리스트 정렬
        Collections.sort(list, ((o1, o2) -> -Integer.compare(o1.plays,o2.plays)));
        List<Integer> temp = new ArrayList<>();
        for (Genre g : list) {
            String genre = g.genres;
            PriorityQueue<Genre> pq = hm.get(genre);
            if (pq.size() == 1) {
                temp.add(pq.poll().num);
            } else {
                temp.add(pq.poll().num);
                temp.add(pq.poll().num);
            }
        }
        int[] answer = new int[temp.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = temp.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"classic", "pop", "classic", "classic", "pop"},new int[]{500, 600, 150, 800, 2500}));
    }
    static class Genre{
        String genres;
        int num;
        int plays;
        Genre(String genres, int num, int plays){
            this.genres = genres;
            this.num = num;
            this.plays = plays;
        }
    }
}
