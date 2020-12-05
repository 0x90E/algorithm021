class Solution {
    // 26 删除排序数组中的重复项
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int p = 0, q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p+1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }

    // 21 合并两个有序链表
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    // 88 合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, q = nums1.length - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[q--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }

        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    // 42 接雨水
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        Deque<Integer> stack = new ArrayDeque<>();
        int sunArea = 0;
        int h;
        for (int i=0; i<height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                h = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                int minHeight = Math.min(height[i], height[stack.peek()]);
                int dist = i - stack.peek() - 1;
                sunArea += dist * (minHeight-h);
            }
            stack.push(i);
        }
        return sunArea;
    }
}

