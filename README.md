# mydsaa
数据结构和算法(Data Structure and Algorithm)的简单学习

## 数据结构
数据结构：计算机存储和组织数据的方式，是相互之间存在一种或多种特定关系的元素的集合。

数据结构的基本功能：

- 插入一条数据
- 删除一条数据
- 修改一条数据
- 查询一条数据 
- 遍历

常用的数据结构：

- 数组Array
- 栈Stack
- 队列Queue
- 链表LinkedList
- 树Tree
- 哈希表Hash
- 堆Heap
- 图Graph

常用数据结构的优缺点

|数据结构|算法总结|
|---|---|
|无序数组|插入快O(1)、按下标修改和查询快O(1)；按值删除、修改和查询慢O(n)；元素类型要求一致；大小固定|
|有序数组|因为有序，所以按值修改、删除和查询比无序数组快O(n)；插入慢(依赖于排序算法)、元素类型要求一致；大小固定|
|栈-数组方式|LIFO原则，只支持栈顶操作O(1)，不支持排序、搜索等操作|
|单向/双向队列-数组方式|FIFO原则，只支持头部和尾部操作O(1)，不支持排序、搜索等操作|
|优先级队列-数组方式|优先原则，只支持入队O(n)和出队操作O(1)，不支持排序、搜索等操作|
|单向链表|插入/删除/查询头节点O(1),查询/删除/修改指定节点O(n);动态大小；无法按下标随机访问|

## 算法
算法：简单来说就是解决问题的步骤。

算法的五个特性：

- 有穷性
- 确定性
- 可行性
- 有输入
- 有输出

算法的设计原则

- 正确性
- 可读性
- 健壮性
- 高效低存储

## 章节列表

- [无序数组](https://github.com/hanchao5272/mydsaa/blob/master/src/main/java/pers/hanchao/dsaa/ds01array/无序数组.md)
- [简单排序：冒泡、选择、插入](https://github.com/hanchao5272/mydsaa/blob/master/src/main/java/pers/hanchao/dsaa/a01simple/简单排序.md)
- [栈](https://github.com/hanchao5272/mydsaa/blob/master/src/main/java/pers/hanchao/dsaa/ds02stack/栈.md)
- [队列](https://github.com/hanchao5272/mydsaa/blob/master/src/main/java/pers/hanchao/dsaa/ds03queue/队列.md)
- [链表](https://github.com/hanchao5272/mydsaa/blob/master/src/main/java/pers/hanchao/dsaa/ds04linkedlist/链表.md)

## 参考说明

- 《Java数据结构和算法》
- http://www.cnblogs.com/ysocean/category/1120217.html
