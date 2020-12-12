class Solution {
   // [剑指 Offer 49]丑数
    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[]{2, 3, 5};
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        minHeap.add(1L);

        int count = 0;
        long current, tmp;
        while (!minHeap.isEmpty()) {
            current = minHeap.remove();

            if (++count == n) {
                return (int) current;
            }

            for (int num : uglyNumbers) {
                tmp = num * current;
                if (!minHeap.contains(tmp) ){
                    minHeap.add(tmp);
                }
            }
        }
        return 0;
    }

    // [347]前 K 个高频元素
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0) return null;
        Map<Integer, Integer> counters = new HashMap<>();
        for (int num : nums) {
            counters.put(num, counters.getOrDefault(num, 0)+1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return counters.get(o1) - counters.get(o2);
            }
        });

        for (int num : counters.keySet()) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else if (counters.get(num) > counters.get(minHeap.peek())) {
                minHeap.remove();
                minHeap.add(num);
            }
        }

        int[] result = new int[k];
        int i = 0;
        while (!minHeap.isEmpty()) {
            result[i++] = minHeap.remove();
        }
        return result;
    }
}
