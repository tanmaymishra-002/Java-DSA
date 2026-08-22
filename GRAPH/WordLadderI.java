import java.util.*;
class Pair {
    String first;
    int number;
    Pair(String first, int number) {
        this.first = first;
        this.number = number;
    }
}
public class WordLadderI {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Set<String> st = new HashSet<>();
        int len = wordList.size();
        for (int i = 0; i < len; i++) {
            st.add(wordList.get(i));
        }
        st.remove(beginWord);
        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().number;
            q.remove();
            if (word.equals(endWord)) {
                return steps;
            }
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);
                    if (st.contains(replacedWord)) {
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList(
            "hot",
            "dot",
            "dog",
            "lot",
            "log",
            "cog"
        );
        int answer = ladderLength(beginWord, endWord, wordList);
        System.out.println("Shortest transformation length: " + answer);
    }
}