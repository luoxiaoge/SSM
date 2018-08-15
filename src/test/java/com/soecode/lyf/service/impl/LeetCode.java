package com.soecode.lyf.service.impl;

/**
 * Function: TODO
 *
 * @author Viki
 * @date 2018/8/2 17:49
 */
public class LeetCode {



    /**
     *  遍历整个序列，每一次循环将最小的数放在最前面。
     *  时间复杂度 0（n^2）
     *  快速排序法
     */
    private static void quickSort(int[] a) {
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i+1; j < a.length; j++) {
                 if (a[i] > a[j]) {
                      temp = a[i];
                      a[i] = a[j];
                      a[j] = temp;
                 }
            }
        }
    }

    /**
     *  冒泡排序
     *  将序列中所有元素两两比较，将最大的放在最后面。
     *  将剩余序列中所有元素两两比较，将最大的放在最后面。
     * @param a 排序数组
     */
    private static void  bubbleSort(int[] a){
        int temp = 0;
        for (int i = 0; i <a.length ; i++) {
            for (int j =0; j<a.length -1 ; j++){
                if (a[j] > a[j + 1]){
                     temp = a[j];
                     a[j] = a[j + 1];
                     a[j + 1] = temp;
                 }
            }
        }
    }

    /**
     *  插入排序
     *  1,硬是将插入算法写成了冒泡  = =
     * @param a 排序数组
     */
    private static void insertSort(int[] a) {
        int temp = 0;
        int tempIndex = 0;
        for (int i = 1; i < a.length; i++) {
             tempIndex = i;
              for (int j = i-1; j >=0; j--,tempIndex--){
                     if (a[j] > a[tempIndex]){
                         temp = a[j];
                         a[j] = a[tempIndex];
                         a[tempIndex] = temp;
                     }
              }
            }
        }

    /**
     *   插入排序
     *   在要排序的一组数中，假设前面(n-1) [n>=2] 个数已经是排好顺序的，
     *   现在要把第n个数插到前面的有序数中，使得这n个数也是排好顺序的。
     *   如此反复循环，直到全部排好顺序。
     *   @param a 数组参数
     */
    private static void insertSort2(int[] a){
         int len = a.length; // 单独把数组长度拿出来
         int insertNum;  // 要插入的数

        for (int i = 1; i < len ; i++) {
             insertNum = a[i]; // 保存要插入的数
             int j = i-1; // 比较数字的位置

             while(j>=0 && a[j] > insertNum){
                a[j+1] = a[j]; // 如果前一位数字大于当前数字 就后移一位
                j--;
            }
             a[j+1] = insertNum;
        }
    }

    /**
     *  leetCode 贪心算法 贪心算法，总是做出在当前看来是最好的选择，不从整体最优上加以考虑，也就是说，只关心当前最优解
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxPro = 0, tmp = 0;
        for (int i = 1; i < prices.length; ++i) {
            tmp = prices[i] - prices[i-1];
            if (tmp > 0)
                maxPro += tmp;
        }
        return maxPro;
    }


    public static void main(String[] args) {
       int[] a = new int[]{7,1,5,3,6,4};


        System.out.println(maxProfit(a));
       /* quickSort(a);
        HashMap<String,Object> b = new HashMap<String, Object>();
        */
      /*  for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }*/

    }
}
