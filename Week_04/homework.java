class Solution {
    // [122]买卖股票的最佳时机 II.java
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;

        int res = 0;
        for (int i=1; i<prices.length; i++) {
            if (prices[i] <= prices[i-1]) continue;
            res += prices[i] - prices[i-1];
        }
        return res;
        
    }

  // [127]单词接龙.java
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) return 0;
        wordSet.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int length = 1;
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i=0; i<currentSize; i++) {
                String currentWord = queue.poll();
                if (changeWordEveryOneLetter(currentWord, endWord, queue, visited, wordSet)) {
                    return length + 1;
                }
            }
            length++;
        }
        return 0;
    }

    public boolean changeWordEveryOneLetter(String currentWord, String endWord, Queue<String> queue, Set<String> visited,
                                            Set<String> wordSet) {

        char[] charArray = currentWord.toCharArray();
        for (int i=0; i<endWord.length(); i++) {
            char originChar = charArray[i];
            for (char k='a'; k<='z'; k++) {
                if (k == originChar) {
                    continue;
                }
                charArray[i] = k;
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(endWord)) {
                        return true;
                    }

                    if (!visited.contains(nextWord)) {
                        queue.add(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            charArray[i] = originChar;
        }
        return false;
    }
}

