class Solution {
    // 242. 有效的字母异位词
    public boolean isAnagram(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return true;
        if (s.length() != t.length()) return false;

        int[] charCount = new int[26];
        for (char a : s.toCharArray()) {
            charCount[a - 'a']++;
        }

        for (char a : t.toCharArray()) {
            if (--charCount[a - 'a'] < 0) return false;
        }
        return true;
    }
    // 56. 合并区间
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return null;
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                res[idx][1] = Math.max(interval[1], res[idx][1]);
            }
        }

        return Arrays.copyOf(res, idx+1);
    }
}
