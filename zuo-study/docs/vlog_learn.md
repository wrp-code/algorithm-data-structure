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

## 9. 