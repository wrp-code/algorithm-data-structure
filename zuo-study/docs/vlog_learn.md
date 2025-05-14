## 1. 开局
1. 使用openai

## 2. Gini基尼系数
> 有好的想法就用代码去实现他
 
## 3. 二进制和位运算
1. 二进制 0b开头
```java
int a = 0b11111001;
```
2. 二进制负数
> 如 -7 到 二进制
> 
> 按照:原码 -> -1 -> 取反
> 
> 00000111 -> 00000110 -> 11111001
> 
> 或按照：原码 -> 取反 -> +1
>
> 00000111 -> 11111000 -> 11111001
> 
> 二进制11111001 到 十进制
> 
> 按照：原码 -> 取反 -> +1,获得绝对值，再加个负号
> 
> 11111001 -> 00000110 -> 00000111 结果为 -7
3. 十六进制 0x开头
```java
int a = 0x1e;
```
4. 二进制 从左往右，高位 到 低位
5. 除最负的那个数的相反数： 取反 ，+1
```java
int a = 7;
int e = ~a + 1;
```
6. 位运算 |、 & 、~ 、^ 、>> 、<< 、>>>
> `|`运算 有1就是1
> 
> `&`算法 两个1才是1
> 
> `~`运算 0变1，1边0
> 
> `^`运算 仅一个1才是1
> 
> `>>`运算 正数高位补0，负数高位补1
> 
> `<<`运算 低位补0
> 
> `>>>`运算 正数负数都高位补0
>
7. 二进制负数为什么要这样设计
   > 为了让正负数的加法保持一致，加减乘除都可以用加法实现
   >
8. 在做运算时，需要自己注意结果不要溢出，否则结果可能不正确

## 4. 选择、冒泡、插入排序
```java
// 升序选择排序
 public void selectSort(int[] arr) {
     if(arr == null || arr.length < 2) return;

     for (int i = 0, min = i; i < arr.length; i++) {
         for (int j = i; j < arr.length; j++) {
             if(arr[j] < arr[min]) {
                 min = j;
             }
         }
         ArrayUtils.swap(arr, i, min);
     }
 }

 // 升序冒泡排序
 public void bubbleSort(int[] arr) {
     if(arr == null || arr.length < 2) return;

     for (int i = arr.length - 1; i > 0; i--) {
         for (int j = 0; j < i; j++) {
             if(arr[j] > arr[j + 1]) {
                 ArrayUtils.swap(arr, j, j + 1);
             }
         }
     }
 }

 // 升序插入排序
 public void insertSort(int[] arr) {
     if(arr == null || arr.length < 2) return;

     for (int i = 1; i < arr.length; i++) {
         for (int j = i; j > 0 && arr[j - 1] > arr[j]; j--) {
             ArrayUtils.swap(arr, j - 1, j);
         }
     }
 }
```
## 5. 对数器
> 用已知正确的算法（暴力解）求证未知的算法是否正确
1. 需要测试的方法a（最优解）
2. 实现复杂度不好但容易实现的方法b（暴力解）
3. 实现一个随机样本产生器（长度随机、值也随机）
4. 方法a、b跑相同的输入样本，看看得到的结果是否一样
5. 如果不一样，打印样本，进行debug
6. 当样本数量很多，且两个结果相同是，可以确认最优解正确

```java
public class C005_Validator {

    /**
     * 生成一个随机数组
     * @param n 数组长度
     * @param v 数字的最大值
     * @return 范围在 1 ~ v的 数组
     */
    public static int[] randomArray(int n, int v){
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * v) + 1;
        }
        return arr;
    }

    /**
     * 复制一个数组
     */
    public static int[] copyArray(int[] arr) {
        if(arr == null) return null;
        return Arrays.copyOf(arr, arr.length);
    }

    /**
     * 判断两个数组是否一样
     */
    public static boolean same(int[] arr1, int[] arr2) {
        if(arr1 == null || arr2 == null || arr1.length != arr2.length) return true;
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void printArray(int[] arr) {
        if(arr == null) return;
        StringBuilder str = new StringBuilder();
        str.append("{");
        for (int n : arr) {
            str.append(n).append(",");
        }

        System.out.println(str.substring(0, str.length() - 1) + "}");
    }

    public static void main(String[] args) {
        int n = 1000;
        int v = 1000;
        int testCount = 10000;
        System.out.println("测试开始");
        for (int i = 0; i < testCount; i++) {
            int r = (int) (Math.random() * n);
            int[] arr = randomArray(r, v);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            int[] arr3 = copyArray(arr);
            Arrays.sort(arr);
            C004_Sort.selectSort(arr1);
            C004_Sort.bubbleSort(arr2);
            C004_Sort.insertSort(arr3);
            if(!same(arr, arr1) || !same(arr, arr2) || !same(arr, arr3) || !same(arr1, arr3)) {
                System.out.println("测试出错了，样本：");
                printArray(arr);
                return;
            }
        }
        System.out.println("测试成功");
    }
}
```
## 6. 二分搜索
### 6.1 一个有序数组，判断是否存在num
```java
    public static boolean exist(int[] arr, int num) {
        if(arr == null || arr.length == 0) return false;
        int l = 0, m, r = arr.length - 1;
        while(l <= r) {
            m = (l + r) / 2;// 可能有溢出问题
            if(arr[m] == num) {
                return true;
            } else if(arr[m] > num) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
```

### 6.2 在有序数组中找>=num的最左位置
```java
    public static int findLeft(int[] arr, int num) {
        int l = 0, m, r = arr.length - 1, res = -1;

        while(l <= r) {
            m = l + ((r - l) >> 1);
            if(arr[m] >= num) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }
```

### 6.3 在有序数组中找<=num的最右位置
```java
    public static int findRight(int[] arr, int num) {
        int l = 0, m, r = arr.length - 1, res = -1;

        while(l <= r) {
            m = l + ((r - l) >> 1);
            if(arr[m] <= num) {
                res = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
```
### 6.4 二分搜索不一定发生在有序数组中（比如寻找峰值问题）
1. 一个随机数组，相邻数不同，数组外的都是极小值
2. 检验0位置和n-1位置是否是峰值
3. 检查中间位置，二分
```java
    public static int peek(int[] arr) {
        if(arr == null || arr.length == 0) return -1;
        int n = arr.length;
        if(n == 1 || arr[0] > arr[1]) return 0;
        if(arr[n - 1] > arr[n - 2]) return n - 1;

        int l = 1, m, r = n - 2, res = -1;
        while(l <= r) {
            m = l + ((r - l) >> 2);
            if(arr[m] < arr[m - 1]) {
                r = m - 1;
            } else if( arr[m] < arr[m + 1]) {
                l = m + 1;
            } else {
                res = m;
                break;
            }
        }
        return res;
    }
```
### 6.5 二分答案法

## 7. 复杂度
> 复杂度描述了一个算法与数据规模之间的关系，分为时间复杂度和空间复杂度，用O表示。
> 
1. 含有随机数的算法，需要用平均期望来求复杂度，如随机快速排序，因为最差情况无意义
2. 复杂度相同的算法，在有限的情况下，可以在常数项优化得很好，如位运算优化N皇后。
3. 最优解，先满足时间复杂度最优，空间复杂度再尽可能小
4. 时间复杂度的均摊，如动态数据扩容，均摊到每次加入元素时的扩容代价是O(1)
5. 不能简单的认为单次循环时间复杂度O(N)，嵌套循环就是O(N²)
6. N + N/2 + N/3 + 。。。 + N/N 收敛于 O(NlogN)
7. O(1) > O(logN) > O(N) > O(N * logN) > O(N^k) > O(k^N) > O(N!)

## 8. 数据结构和算法的大致分类
### 8.1 算法分类
1. 硬计算类算法
> 精确求解。算法笔试面试，acm比赛等

2. 软计算类算法
> 更注重逼近解决问题，而不是精确求解。模糊逻辑、神经网络、进化计算、概率理论、混沌理论、支持向量机、群体智能
> 

### 8.2 数据结构分类
1. 连续结构
> 存储空间连续，如数组
2. 跳转结构
> 存储空间不连续，通过地址指针连接，如链表
> 

## 9. 链表及其反转
### 9.1 按值传递和按引用传递
```java
    public static class Number {
        int val;

        public Number(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int a = 10;
        f1(a);
        System.out.println(a);

        Number b = new Number(5);
        g1(b);
        System.out.println(b.val);
        g2(b);
        System.out.println(b.val);
    }

    // 不影响
    public static void f1(int a) {
        a = 0;
    }

    // 不影响 !!!
    public static void g1(Number a) {
        a = null;
    }

    // 影响
    public static void g2(Number a) {
        a.val = 10;
    }
```
### 9.2 反转单链表
```java
    // 反转单链表
    public static Node reverse(Node head) {
        Node prev = null;
        Node next;
        while(head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // 反转双向链表
    public static DeNode reverse(DeNode head) {
       DeNode prev = null;
       DeNode next;
       while(head != null) {
          next = head.next;
          head.next = prev;
          head.prev = next;
          prev = head;
          head = next;
       }
       return prev;
    }
```

## 10. 合并有序列表
```java
    // 合并两个有序链表
    public static Node merge(Node head1, Node head2) {
        if(head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        Node head = head1.val <= head2.val ? head1 : head2;
        Node cur1 = head == head1 ? head2.next : head1.next;
        Node cur2 = head.next;
        Node prev = head;
        while(cur1 != null && cur2 != null) {
            if(cur1.val <= cur2.val) {
                prev.next = cur1;
                cur1 = cur1.next;
            } else  {
                prev.next = cur2;
                cur2 = cur2.next;
            }
            prev = prev.next;
        }

        prev.next = cur1 == null ? cur2 : cur1;
        return head;
    }
```

## 11. 链表模拟算数加法
> 4 -> 2 -> 8  
> 
> 2 -> 1 -> 3
> 
> 824 + 312
> 
```java
    public static Node add(Node head1, Node head2) {
        Node res = null;
        Node cur = null;
        int carry = 0;
        int sum;
        for(Node p1 = head1,p2 = head2; p1 != null || p2 != null;
            p1 = p1==null ? null : p1.next, p2 = p2==null ? null : p2.next) {
            sum = (p1 == null ? 0 : p1.val) +
                    (p2 == null ? 0 : p2.val) + carry;
            carry = sum / 10;
            sum = sum % 10;
            if(res == null) {
                res = new Node(sum, null);
                cur = res;
            } else {
                cur.next = new Node(sum, null);
                cur = cur.next;
            }
        }
        if(carry > 0) {
            cur.next = new Node(carry, null);
        }
        return res;
    }
```

## 12. 划分链表
> 小于k的在左边，大于等于k的在右边，相对顺序不变
> 
```java
    public static Node partition(Node head, int x) {
        Node leftHead = null, leftTail = null;
        Node rightHead = null, rightTail = null;
        Node next;
        while(head != null) {
            next = head.next;
            head.next = null;
            if(head.val >= x) {
                if(rightHead == null) {
                    rightHead = head;
                }else {
                    rightTail.next = head;
                }
                rightTail = head;
            } else {
                if(leftHead == null) {
                    leftHead = head;
                }else {
                    leftTail.next = head;
                }
                leftTail = head;
            }
            head = next;
        }

        if(leftHead == null){
            return rightHead;
        }
        leftTail.next = rightHead;
        return leftHead;
    }
```

## 13. 队列和栈

### 13.1 队列
> 先进先出
> 
1. 链表实现
```java
    public static class Queue1 {
        // 双端队列
        Queue<Integer> queue = new LinkedList<>();

        public boolean isEmpty() {
            return queue.isEmpty();
        }

        public void offer(Integer integer) {
            queue.offer(integer);
        }

        public Integer poll() {
            return queue.poll();
        }

        public Integer peek() {
            return queue.peek();
        }
    }
```
2. 数组实现
```java
    public static class Queue2 {
        int[] arr;
        int head;
        int tail;

        public Queue2(int n) {
            arr = new int[n];
            head = 0;
            tail = 0;
        }

        public boolean isEmpty() {
            return head == tail;
        }

        public void offer(Integer integer) {
            arr[tail++] = integer;
        }

        public Integer poll() {
            return arr[head--];
        }

        public Integer peek() {
            return arr[head];
        }

        public int size() {
            return tail - head;
        }
    }
```

3. 循环数组实现

### 13.2 栈
> 先进后出
```java
    public static class Stack1 {
        Stack<Integer> stack = new Stack<>();
    }

    public static class Stack2 {
        int[] arr;
        int size;
        public Stack2(int n) {
            arr = new int[n];
            size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void push(int num) {
            arr[size++] = num;
        }

        public int pop() {
            return arr[--size];
        }

        public int peek() {
            return arr[size - 1];
        }

        public int size(){
            return size;
        }
    }
```
## 14. 队列和栈相互实现
1. 栈实现队列
```java
   public static class MyQueue {
      Stack<Integer> in;
      Stack<Integer> out;
   
      public MyQueue() {
         in = new Stack<>();
         out = new Stack<>();
      }
   
      public void inToOut() {
         if(!out.isEmpty()) return;
   
         while(!in.isEmpty()) {
            out.push(in.pop());
         }
      }
   
      public void push(int x) {
         in.push(x);
         inToOut();
      }
   
      public int pop() {
         inToOut();
         return out.pop();
      }
   
      public int peek() {
         inToOut();
         return out.peek();
      }
   
      public boolean empty() {
         return in.isEmpty() && out.isEmpty();
      }
   }
```
2. 队列实现栈
```java
    public static class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        // O(N)
        public void push(int x) {
            int size = queue.size();
            queue.offer(x);
            for (int i = 0; i < size; i++) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int peek() {
            return queue.peek();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }
```
## 15. 最小栈实现
> 任何时候都能够获取到栈里的最小元素
```java
    class MyStack1 {
        // 系统带的栈O(1),但是常数项不好，性能慢
        Stack<Integer> data;
        Stack<Integer> min;

        public MyStack1() {
            data = new Stack<>();
            min = new Stack<>();
        }

        public void push(int x) {
            data.push(x);
            if(min.isEmpty() || x <= min.peek()) {
                min.push(x);
            } else {
                min.push(min.peek());
            }
        }

        public int pop() {
            min.pop();
            return data.pop();
        }

        public int peek() {
            return data.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

    class MyStack2 {
        // 自己实现栈
        int[] data;
        int[] min;
        int size;
        final int DEFAULT = 10000;

        public MyStack2() {
            data = new int[DEFAULT];
            min = new int[DEFAULT];
        }

        public void push(int x) {
            data[size] = x;
            if(size == 0 || x <= min[size]) {
                min[size] = x;
            } else {
                min[size] = min[size - 1];
            }
            size++;
        }

        public int pop() {
            return data[--size];
        }

        public int peek() {
            return data[size - 1];
        }

        public int getMin() {
            return min[size - 1];
        }
    }
```
## 16.双端队列
> 双向链表和固定数组实现双端队列
> 
1. 双向链表实现双端队列
```java
    static class MyCircularDeque1 {
        public Deque<Integer> deque = new LinkedList<>();
        public int limit;

        public MyCircularDeque1(int limit) {
            this.limit = limit;
        }

        public boolean insertFront(int value) {
            if(isFull()) {
                return false;
            }
            deque.offerFirst(value);
            return true;
        }

        public boolean insertLast(int value) {
            if(isFull()) {
                return false;
            }
            deque.offerLast(value);
            return true;
        }

        public boolean deleteFront() {
            if(isEmpty()) {
                return false;
            }
            deque.pollFirst();
            return true;
        }

        public boolean deleteLast() {
            if(isEmpty()) {
                return false;
            }
            deque.pollLast();
            return true;
        }

        public int getFront() {
            return deque.peekFirst();
        }

        public int getRear() {
            return deque.peekLast();
        }

        public int size() {
            return deque.size();
        }

        public boolean isEmpty() {
            return deque.isEmpty();
        }

        public boolean isFull() {
            return deque.size() == limit;
        }
    }
```
2. 固定数组实现双端队列
```java
// 固定数组实现
    static class MyCircularDeque2 {
        int[] data;
        public int size;
        public int limit;
        int r;
        int l;

        public MyCircularDeque2(int limit) {
            size = r = l = 0;
            this.limit = limit;
            data = new int[limit];
        }

        public boolean insertFront(int value) {
            if(isFull()) {
                return false;
            }
            if(isEmpty()) {
                l = r = 0;
            } else {
                l = l==0 ? limit - 1 : l-1;
            }
            data[l] = value;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if(isFull()) {
                return false;
            }
            if(isEmpty()) {
                l = r = 0;
            } else {
                r = r==limit-1 ? 0 : r + 1;
            }
            data[r] = value;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if(isEmpty()) {
                return false;
            }
            l = l==limit-1 ? 0: l+1;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if(isEmpty()) {
                return false;
            }
            r = r==0 ? limit-1: l-1;
            size--;
            return true;
        }

        public int getFront() {
            if(isEmpty()) {
                return -1;
            }
            return data[l];
        }

        public int getRear() {
            if(isEmpty()) {
                return -1;
            }
            return data[r];
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == limit;
        }
    }
```
## 17. 二叉树及其三种序的递归实现
> - 先序遍历 根左右
> - 中序遍历 左根右
> - 后续遍历 左右根

递归序
```java
    public static void f(TreeNode root) {
        if(root == null) {
            return;
        }
        // 1.
        f(root.left);
        // 2.
        f(root.right);
        // 3.
    }
```

## 18. 非递归实现二叉树遍历
> - 先序遍历，使用栈实现
> - 中序遍历，使用栈实现
>   - 树的左边界全部入栈，弹栈处理，再跳到右树，循环
> - 后序遍历，使用一个/两个栈实现

## 19. 笔试中的输入输出
1. 填函数风格
2. acm风格
   - 规定测试数据量（BufferedReader、StreamTokenizer、PrintWriter)
   - 按行读（BufferedReader、PrintWriter）
   - 不要用Scanner、System.out，效率低
3. 不推荐：临时动态分配空间
4. 推荐：全局静态空间

## 20. 递归和master公式
1. 递归本质上利用了系统栈空间
2. 任何递归都可以改成非递归（工程上一定要改，算法笔试中能过就行）
3. master公式
   - 只能处理子问题规模相同的情况
   - T(N) = a * T(N / b) + o(N^c^)
   - log(a,b) < c， 复杂度： O(N^c^)
   - log(a,b) > c， 复杂度： O(N^log(a,b)^)
   - log(a,b) = c， 复杂度： O(N^c^ * logN)
   - T(N) = 2 * T(N / 2) + o(N * logN)，复杂度为O(N*(logN)^2^)，记住即可

## 21. 归并排序
> O(N * logN)，本质是没有浪费比较行为，每次合并后都形成了局部有序，所以比O(N^2^)快
> 
思路：
1. 分左右两部分排好序
2. 合并两部分
3. base case： 左边界 = 右边界时返回


## 22. 分治算法
> 以下两点都满足，可以考虑归并分治算法
> 1. 思考一个问题在大范围上的答案，是否等于，左部分的答案 + 右部分的答案 + 跨越左右的答案
> 2. 计算“跨越左右产生的答案”时，如果加上左、右各自有序这个设定，会不会获得计算的便利性
> 
### 22.1 小和问题


### 22.2 翻转对问题

## 23. 随机快排
> 荷兰国旗版随机快排，空间O(logN) 时间O(N*logN)




