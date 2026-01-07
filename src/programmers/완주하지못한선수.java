package programmers;

import java.util.*;

public class 완주하지못한선수 {
    static HashMap<String, Integer> map;

    public static String solution(String[] participant, String[] completion) {
        map = new HashMap<>();
        String answer = "";
        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.get(completion[i]) - 1);
        }
//      쓰레기
        for (int i = 0; i < participant.length; i++) {
            if (map.get(participant[i]) > 0) {
                answer = participant[i];
            }
        }
//      hashmap 순회(if 가능)
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value > 0) {
                answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }
}