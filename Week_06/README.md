学习笔记

1. 与递归或分治没有根本上点区别，都是要找到重复子问题
2. 递归/分治是至顶向下的思维，可以使用记忆化搜索减少递归的层数，达成降低时间复杂度
3. 动态规划是至底向上的思维，相对于其他二者，其拥有最优子结构，所以是分治+最优子结构
4. 因为有最优子结构，所以存最优解即可；换言之，每次都淘汰次优解
5. 与贪婪算法类似，动态规划也要证明若每一步存在最优值，最后能推导出一个全局最优值
6. 爬楼梯、解码方法的DP方程可以参考分类计数加法原理和分步计数乘法原理

动态规划解题
1. 寻找重复性（分治）
2. 定义状态数组，并设定初始化状态
3. 推导DP方程（递推公式）
