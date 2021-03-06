学习笔记
第三课相关作业根据用到的数据分成两类，数组与链表：
1. 数组：
  - 优势在其数据放在连续的内存中，可以在随机存取时有0(1)
  - 缺点是在删除、插入都需要O(N)，所以若在平常使用时，尽量都预估一下Array所需都大小，避免频繁扩容
  - 应用
     - 每个解题上来，二话不说先写if (nums == null || nums.length == 0) return 0;
     - length与index总是差1，在循环时要注意
     - 使用java提供的System.arraycopy进行Array copy
2. 链表
  - 优势在删除、插入需要O(1)
  - 缺点的查找需要O(N)，且需要额外的point空间，32bit下为4 byte，64bit下为8byte
  - 若链表过长，可以考虑以下优化
    - 树化，例如Java 1.8中的HashMap优化
    - 跳表，例如Redis底层的Sorted Set的实现，最初是使用压缩列表实现，到达一定阈值时，转换成为跳表；但跳表只能存储有序数据
  - 应用
     - 作业21 合并两个有序链表 与实战24 两两交换链表中的节点都使用到链链表已经递归，是蛮优雅的解法
       - 递归需要注意几件事情
         - 返回值
         - 调用单元(每层)要做什么
         - 终止条件
     - 这链表题的终止条件不外乎node == null 或 node.next == null
     - 返回值与每层逻辑则根据题目实现
有趣的是本周在学习群同学讨论ArrayList与LinkedList在头插入、中间插入、尾插入的比较，当中比较引入注意的是中间插入与尾插入，在连续执行的情况下，因为CPU缓存加速，反而是ArrayList是效率更高

第四课相关作业为42，其使用到Stack，这题与实战84 柱状图中最大的矩形，有异曲同工之妙，都是单调栈的应用，其中接雨水是要用两根柱子之间的空白处解雨水，所以若柱比栈顶的柱低或相等(还有空白空间可以解雨水)，则押入栈(维持一个单调递减的栈)，若碰到一个高于栈顶的柱，表示可以形成一个盆，可以进行计算了；而柱状图中最大的矩形是用柱子本身的面积做计算，所以是若柱子比栈顶的柱高或相等(面积还可以连续)，则押入栈(维持一个单调递增的栈)，碰到一个低于栈顶的柱，表示面积无法继续，就进行计算
- 栈
  - 应用
    - Java使用ArrayDeque实现Stac k
    - stack.isEmpty()是终止条件
    - stack.peek()是读取栈顶信息，而pop()则会出栈，每次pop先用isEmpty()判断，不然会NPE

