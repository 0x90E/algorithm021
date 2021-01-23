学习笔记
### 位运算
- 主要是记忆位运算的使用时机；例如判断奇偶、乘除2、清除/获得最低位0

### 布隆过滤器
- 布隆过滤器使用bitmap + 多组Hash function构建
- 应用在不需存放整个Key与Value，而只要快速判断key是否在talbe中的场景
- 因为hash碰撞的原因，可能会造成误报情况，就是判断在Table内但却不在，所以需要搭配后端存放完整Key的容器再次判断

### LRU cache
- 为一种缓存替换策略，当缓存空间不足以存放新近元素时，淘汰最久没有使用到的元素
- 查询、修改、更新皆为O(1)
- 数据结构: Hash Table + Double LinkedList
- 基础操作: new LRUCache、get、put

### 排序算法
- 根据排序对象是否可以是自定义对象(传入comparator function)做排序，或者只能为整形元素分为比较类排序、非比较类排序
- 比较类排序分为初级排序、高级排序
- 初级排序较原始，使用两层loop进行排序操作，时间复杂度为O(N^2)，包含冒泡排序、插入排序、选择排序
- 高级排序将时间复杂度降为O(NLogN)，包含快速排序、合并排序、堆排序
- 逆序对：指在一数组中，低位元素的值大与高位元素的值；此类问题使用合并排序进行求解

### Bubble Sort
``` java 
    public static int[] bubbleSort(int[] nums) {
        for (int i=0; i<nums.length-1; i++) {
            for (int j=0; j<nums.length-i-1; j++) {
                if (nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
        return nums;
    }
```

### Insert Sort
``` java
    public static int[] insertSort(int[] nums) {
        int k;
        for (int i=1; i<nums.length; i++) {
            int num = nums[i];
            k = i - 1;
            while (k >= 0 && nums[k] > num) {
                nums[k+1] = nums[k--];
            }
            nums[k+1] = num;
        }
        return nums;
    }
```

### Select Sort
``` java
    public static int[] selectSort(int[] nums) {
        for (int i=0; i<nums.length-1; i++) {
            int minIndex = i;
            for (int j=i+1; j<nums.length; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
                int tmp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = tmp;
            }
        }

        return nums;
    }
```
