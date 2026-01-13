package programmers;

import java.util.*;

public class 같은숫자는싫어 {
    static Stack<Integer> s;

    public static int[] Solution(int[] arr) {
        s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (s.size() == 0) {
                s.push(arr[i]);
                continue;
            }
            while (s.size() > 0 && s.peek() == arr[i]) {
                s.pop();
            }
            s.push(arr[i]);
        }
        int[] answer = new int[s.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = s.pop();
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Solution(new int[]{1,1,3,3,0,1,1}));
    }
}
