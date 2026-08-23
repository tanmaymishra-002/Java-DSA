import java.util.*;
class Solution {
    public List<List<String>> findLadders(
            String beginWord,
            String endWord,
            List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        // Dictionary
        Set<String> st = new HashSet<>();
        for (String word : wordList) {
            st.add(word);
        }
        // If endWord is not present, no transformation is possible
        if (!st.contains(endWord)) {
            return ans;
        }
        Map<String, List<String>> parents = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        boolean found = false;
        while (!q.isEmpty() && !found) {
            int size = q.size();
            Set<String> levelVisited = new HashSet<>();
            for (int k = 0; k < size; k++) {
                String word = q.remove();
                for (int i = 0; i < word.length(); i++) {
                    char[] replacedCharArray = word.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        replacedCharArray[i] = ch;
                        String replacedWord =
                                new String(replacedCharArray);
                        if (st.contains(replacedWord)) {
                            if (!visited.contains(replacedWord)) {
                                visited.add(replacedWord);
                                levelVisited.add(replacedWord);
                                q.add(replacedWord);
                                List<String> list = new ArrayList<>();
                                list.add(word);
                                parents.put(replacedWord, list);
                            }
                            else if (levelVisited.contains(replacedWord)) {
                                parents.get(replacedWord).add(word);
                            }
                            if (replacedWord.equals(endWord)) {
                                found = true;
                            }
                        }
                    }
                }
            }
        }
        if (!found) {
            return ans;
        }
        List<String> path = new ArrayList<>();
        path.add(endWord);
        dfs(endWord, beginWord, parents, path, ans);
        return ans;
    }
    private void dfs(
            String word,
            String beginWord,
            Map<String, List<String>> parents,
            List<String> path,
            List<List<String>> ans) {
        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }
        for (String parent : parents.get(word)) {
            path.add(parent);
            dfs(parent, beginWord, parents, path, ans);
            // Backtrack
            path.remove(path.size() - 1);
        }
    }
}
public class WordLadder2 {
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
        Solution solution = new Solution();
        List<List<String>> result =
                solution.findLadders(beginWord, endWord, wordList);
        System.out.println("All shortest transformation sequences:");
        for (List<String> path : result) {
            System.out.println(path);
        }
    }
}