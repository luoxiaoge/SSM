package com.soecode.lyf.service.impl;

import java.util.*;

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

    /**
     *  从排序数组中取出重复的数字
     * @param nums 已排序数组
     * @return 拍好的顺序
     */
    public int removeDuplicates(int[] nums) {
        int number = 0;
        for (int i=0; i < nums.length ; i++) {
            if ( nums[i] != nums[number] ) {
                number++;
                nums[number] = nums[i];
            }
        }
        number+=1;
        return number;
    }


     /** 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 要求使用空间复杂度为 O(1) 的原地算法。
     * @param nums
     * @param k
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     *
     *
     */
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        int toMove;
        HashMap<Integer,Object> position = new HashMap();
        for (int i = 0; i < len ; i++) {
              toMove = i + k;
              if (toMove >= len) toMove = toMove - len;
              position.put(toMove,nums[i]);
        }

       // 遍历 hashMap
        for (Integer o: position.keySet()){
            nums[o] = (Integer) position.get(o);
        }

    }

    /**
     * 给定一个整数数组，判断是否存在重复元素。
     * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     * @param nums
     * @return
     */
    public static  boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len ; i++) {
            for (int j = i + 1; j < len ; j++) {
                 if (nums[i] == nums[j])
                     return true;
            }
        }
        return false;

     /* 执行用时为 5 ms 的范例
       Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;*/
    }

    // 1 1 2 2 4
    public static int singleNumber(int[] A) {
 /*       int len = nums.length;
        Arrays.sort(nums);
        if( len == 1) return nums[0];
        for (int i = 1; i <len; i++) {
            System.out.println(nums[i]);
            if (i > 1 && i < len - 1) {
                if (nums[i - 1] != nums[i] && nums[i] != nums[i + 1]) {
                    System.out.println('cccc'+ i);
                    return nums[i];
                }
            }
            if (i == 1 && nums[i - 1] != nums[i]) {
                System.out.println('bbbb'+ i);
                return nums[i - 1];
            }
            if (i == len - 1 && nums[i - 1] != nums[i]) {
                System.out.println('aaaa'+ i);
                return nums[i];
            }
        }
        return 0;*/

        if (A == null || A.length == 0) {
            return -1;
        }
        int rst = 0;
        for (int aA : A) {
            rst ^= aA;
        }
        return rst;
    }


    public static int[] rotate2(int[] nums, int k) {
        int[] nums2 = new int[nums.length];
        int len = nums.length;
        int tomove;
        for (int i = 0; i < len ; i++) {
            tomove = i + k;
            if (tomove >= len) tomove-=len;
                nums2[tomove] = nums[i];
        }
        return nums2;
    }

    /**
     给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     你可以假设除了整数 0 之外，这个整数不会以零开头。
     */
    public static int[] plusOne(int[] digits) {
        if (digits.length == 0) return digits;
        int carry = 1, n = digits.length;
        for (int i = digits.length - 1; i >= 0; --i) {
            if (carry == 0) return digits;
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return carry == 0 ? digits : res;
    }


    public static int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int temolen = len1 > len2 ? len1 : len2;
        Map<Integer,Integer>  a= new HashMap();
        Map<Integer,Integer> b = new HashMap();
        for (int i = 0; i < temolen; i++) {
            if (i < len1 && a.containsKey(nums1[i])) {
                a.put(nums1[i], a.get(nums1[i]) + 1);
            }else{
                if (i<len1)
                    a.put(nums1[i],1);
            }

            if (i < len2 && b.containsKey(nums2[i])) {
                b.put(nums2[i], b.get(nums2[i]) + 1);
            }else {
                if (i < len2)
                    b.put(nums2[i],1);
            }

        }
        List<Integer> num3 = new ArrayList();
        for (Integer o : a.keySet()) {
            if (b.containsKey(o)) {
                int temp = a.get(o) > b.get(o) ? b.get(o) : a.get(o);
                for (int i = 0; i < temp; i++) {
                    num3.add(o);
                }
            }
        }

        int[]   nums3 = new int[num3.size()];
        for (int i = 0; i < num3.size() ; i++) {
             nums3[i] = num3.get(i);
        }


       return   nums3;
        // 实例代码
     /*   Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] result;
        if(nums1.length > nums2.length){
            result = new int[nums2.length];
        }else{
            result = new int[nums1.length];
        }
        int i=0,j=0,z=-1;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                result[++z]=nums1[i];
                i++;
                j++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                i++;
            }
        }
        int[] result1=new int[z+1];
        for(int k=0;k<=z;k++){
            result1[k]=result[k];
        }
        return result1;*/
    }
       // return c == true ? a:b;

    /**
     *  给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *  因为可能首位为0 ，所以重新排了2次 其实可以 从最后开始
     * @param nums
     */
    public  static void moveZeroes(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len ; i++) {
             if (nums[i] == 0){
                 for (int j = i; j < len -1;j++) {
                     //if (j != i && nums[j]==0)
                      nums[j] = nums[j+1];
                 }
                 nums[len -1] =0;
             }
        }

        for (int i = 0; i < len ; i++) {
            if (nums[i] == 0){
                for (int j = i; j < len -1;j++) {
                    //if (j != i && nums[j]==0)
                    nums[j] = nums[j+1];
                }
                nums[len -1] =0;
            }
        }


    }


    public  static int[] twoSum(int[] nums, int target) {
        int[] nums2 = new int[2];
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i+1; j < nums.length; j++) {
                  if (nums[i] + nums[j] == target){
                      nums2[0] = i;
                      nums2[1] = j;
                  }
            }
        }

        System.out.println(Arrays.toString(nums2));
        return  nums2;
    }


    public static boolean isValidSudoku(char[][] board) {
        Map<Character,Object> validateRowMap = new HashMap();
        Map<Character,Object> validatColumnMap = new HashMap();
        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[i].length ; j++) {
                char tempChar = board[i][j];
                if (tempChar != '.') {
                    // 判断一行是否相同的数字
                    if (validateRowMap.containsKey(tempChar) && (Integer) validateRowMap.get(tempChar) == j) {
                        return false;
                    }
                    // 判断一列是否有相同的数字
                    if (validatColumnMap.containsKey(tempChar) && (Integer) validatColumnMap.get(tempChar) == i) {
                        return false;
                    }
                    validateRowMap.put(tempChar, j);
                    validatColumnMap.put(tempChar, i );
                }
            }
        }
        // 判断三乘三的重复
        Map<Character, Object> rowColumnMap = new HashMap();
        for (int i = 0; i < board.length; i++) {
            if (i%3 ==0 && i!=0) {
                rowColumnMap.clear();
            }
            for (int j = 0; j < 3; j++) {
                char tempChar = board[i][j];
                if (tempChar != '.') {
                    if (rowColumnMap.containsKey(tempChar)) {
                        return false;
                    }
                    rowColumnMap.put(board[i][j], j);
                }
            }

        }

        rowColumnMap.clear();
        for (int i = 0; i < board.length; i++) {
            if (i%3 ==0 && i!=0) {
                rowColumnMap.clear();
            }
            for (int j = 3; j < 6; j++) {
                char tempChar = board[i][j];
                if (tempChar != '.') {
                    if (rowColumnMap.containsKey(tempChar)) {
                        return false;
                    }
                    rowColumnMap.put(board[i][j], j);
                }
            }
        }

        rowColumnMap.clear();
        for (int i = 0; i < board.length; i++) {
            if (i%3 ==0 && i!=0) {
                rowColumnMap.clear();
            }
            for (int j = 6; j < 9; j++) {
                char tempChar = board[i][j];
                if (tempChar != '.') {
                    if (rowColumnMap.containsKey(tempChar)) {
                        return false;
                    }
                    rowColumnMap.put(board[i][j], j);
                }
            }
        }
        return true;
    }





    public static void main(String[] args) {
        int n =5;
        int n1 =1;

        for (int i = 1; i <=n ; i++) {
             n1 *= i;
        }

        System.out.println(n1);


    }
}
