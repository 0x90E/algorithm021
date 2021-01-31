学习笔记
这礼拜依旧是被DP摁在地上摩擦的一周
动态规划解题
1. 寻找重复性（分治）
2. 定义状态数组，并设定初始化状态
3. 推导DP方程（递推公式）

股票买卖问题，参考labuladong的算法小抄的DP状态转移方程
``` java
base case：
dp[-1][k][0] = dp[i][0][0] = 0
dp[-1][k][1] = dp[i][0][1] = -infinity

状态转移方程：
dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
```
